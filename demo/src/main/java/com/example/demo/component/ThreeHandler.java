package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component
public class ThreeHandler implements AbstractHandler {
    @Override
    public void handle() {
        System.out.println("Clean coffee maker...");
    }

    @Override
    public String type() {
        return "3";
    }
}
