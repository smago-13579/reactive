package com.example.demo.service;

import com.example.demo.annotation.InjectList;
import com.example.demo.component.AbstractHandler;
import com.example.demo.component.OneHandler;
import com.example.demo.component.TwoHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DemoServiceOne {
    private final String one;
    private final ApplicationContext context;
    private final List<AbstractHandler> handlers;

    public DemoServiceOne(@Qualifier("one") String one,
                          ApplicationContext context,
                          @InjectList(value = {OneHandler.class, TwoHandler.class})
                          List<AbstractHandler> handlers) {
        this.one = one;
        this.context = context;
        this.handlers = handlers;
    }

    @PostConstruct
    void init() {
        System.out.println("DemoServiceOne: " + handlers);
    }

    public void handle() {
        this.handlers.forEach(AbstractHandler::handle);
    }
}
