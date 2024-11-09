package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component
public class TwoHandler implements AbstractHandler {
    @Override
    public void handle() {
        System.out.println("Pour the water...");
    }

    @Override
    public String type() {
        return "2";
    }
}
