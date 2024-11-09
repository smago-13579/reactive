package com.example.demo.bpp;

import com.example.demo.annotation.InjectList;
import com.example.demo.annotation.InjectMap;
import com.example.demo.component.AbstractHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;

import java.beans.Introspector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InjectMapBPP implements BeanPostProcessor {
    @Autowired
    private ApplicationContext context;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        List<Constructor<?>> constructors = Stream.of(bean.getClass().getConstructors())
                .filter(it -> Stream.of(it.getParameters()).anyMatch(p -> p.isAnnotationPresent(InjectMap.class)))
                .toList();

        for (Constructor<?> constructor : constructors) {
            Parameter[] parameters = constructor.getParameters();
            Object[] constructorArgs = new Object[parameters.length];

            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];

                if (parameter.isAnnotationPresent(InjectMap.class)) {
                    InjectMap injectMap = parameter.getAnnotation(InjectMap.class);
                    Map<String, Object> map = Stream.of(injectMap.value())
                            .map(aClass -> Introspector.decapitalize(aClass.getSimpleName()))
                            .collect(Collectors.toMap(key -> {
                                return ((AbstractHandler) context.getBean(key)).type();
                            }, value -> context.getBean(value)));

                    constructorArgs[i] = map;
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
