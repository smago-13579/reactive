package com.example.reactor.controller;

import com.example.reactor.config.GreetingsConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationPropertiesScan("com.example")
public class GreetingController {
    private final GreetingsConfig greetings;

    public GreetingController(GreetingsConfig greetings) {
        this.greetings = greetings;
    }

    @PostConstruct
    void init() {
        System.out.println(greetings.getName());
        System.out.println(greetings.getCoffee());
    }
}
