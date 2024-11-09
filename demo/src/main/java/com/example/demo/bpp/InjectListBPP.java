package com.example.demo.bpp;

import com.example.demo.annotation.InjectList;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;

import java.beans.Introspector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.stream.Stream;

public class InjectListBPP implements BeanPostProcessor {
    @Autowired
    private ApplicationContext context;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        List<Constructor<?>> constructors = Stream.of(bean.getClass().getConstructors())
                .filter(it -> Stream.of(it.getParameters()).anyMatch(p -> p.isAnnotationPresent(InjectList.class)))
                .toList();

        for (Constructor<?> constructor : constructors) {
            Parameter[] parameters = constructor.getParameters();
            Object[] constructorArgs = new Object[parameters.length];

            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];

                if (parameter.isAnnotationPresent(InjectList.class)) {
                    InjectList injectList = parameter.getAnnotation(InjectList.class);
                    List<Object> list = Stream.of(injectList.value())
                            .map(aClass -> Introspector.decapitalize(aClass.getSimpleName()))
                            .map(name -> context.getBean(name)).toList();

                    constructorArgs[i] = list;
                } else {
                    try {
                        if ("ApplicationContext".equals(parameter.getType().getSimpleName())) {
                            constructorArgs[i] = context;
                        } else if (context.containsBean(Introspector.decapitalize(parameter.getType().getSimpleName()))) {
                            constructorArgs[i] = context.getBean(Introspector.decapitalize(parameter.getType().getSimpleName()));
                        } else {
                            constructorArgs[i] = context.getBean(parameter.getName());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                return constructor.newInstance(constructorArgs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}
