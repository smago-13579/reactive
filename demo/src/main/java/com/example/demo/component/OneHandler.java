package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component
public class OneHandler implements AbstractHandler {
    @Override
    public void handle() {
        System.out.println("Put the coffee beans...");
    }

    @Override
    public String type() {
        return "1";
    }
}
