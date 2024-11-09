package com.example.demo.config;

import com.example.demo.bpp.InjectListBPP;
import com.example.demo.bpp.InjectMapBPP;
import com.example.demo.service.DemoServiceOne;
import com.example.demo.service.DemoServiceTwo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class DemoConfig {

    @Bean("one")
    public String myString() {
        return "one";
    }

    @Bean("two")
    public String anotherString() {
        return "two";
    }

    @Bean
    public InjectListBPP injectListBPP() {
        return new InjectListBPP();
    }

    @Bean
    public InjectMapBPP injectMapBPP() {
        return new InjectMapBPP();
    }

//    @Bean
//    public DemoServiceOne demoService(String one, ApplicationContext context) {
//        return new DemoServiceOne(one, context, null);
//    }
//
//    @Bean
//    public DemoServiceTwo demoServiceTwo() {
//        return new DemoServiceTwo(null);
//    }
}
