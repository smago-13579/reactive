package com.example.reactor.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "greeting")
public class GreetingsConfig {
    private String name;
    private String coffee;
}
