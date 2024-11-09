package com.example.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.order")
public class OrderConfig {

    @Bean
    public String greeting() {
        return "Hello customers...";
    }
}
