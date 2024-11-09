package com.example.demo.service;

import com.example.demo.annotation.InjectList;
import com.example.demo.component.AbstractHandler;
import com.example.demo.component.ThreeHandler;
import com.example.demo.component.TwoHandler;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DemoServiceTwo {
    private final List<AbstractHandler> handlers;

    public DemoServiceTwo(@InjectList({ThreeHandler.class, TwoHandler.class})
                       List<AbstractHandler> handlers) {
        this.handlers = handlers;
    }

    @PostConstruct
    void init() {
        System.out.println("DemoServiceTwo: " + handlers);
    }

    public void handle() {
        handlers.forEach(AbstractHandler::handle);
    }
}
