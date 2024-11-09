package com.example.order.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final String greeting;

    public OrderService(String greeting) {
        this.greeting = greeting;
    }

    public void createOrder() {
        System.out.println(greeting);
        System.out.println("The order has been created...");
    }
}
