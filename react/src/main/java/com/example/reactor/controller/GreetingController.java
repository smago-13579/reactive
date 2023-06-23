package com.example.reactor.controller;

import com.example.reactor.config.Droid;
import com.example.reactor.config.GreetingsConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("greeting")
@ConfigurationPropertiesScan("com.example")
public class GreetingController {
    private final GreetingsConfig greetings;
    private final Droid droid;

    public GreetingController(GreetingsConfig greetings, Droid droid) {
        this.greetings = greetings;
        this.droid = droid;
    }

    @PostConstruct
    void init() {
        System.out.println(greetings.getName());
        System.out.println(greetings.getCoffee());
        System.out.println(droid.getId());
        System.out.printf(droid.getDescription());
    }

    @PostMapping("/save")
    public void saveText(@RequestBody String text) {
        List<String> list = Arrays.asList(text.split("\n"));

        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
    }

    @PostMapping("/saveFile")
    public void saveFile(@RequestBody byte[] body) {
        File file = new File("testfile");
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(body);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        String string = new String(file, StandardCharsets.UTF_8);
//        List<String> list = Arrays.asList(string.split("\n"));
//
//        list.forEach(System.out::println);
    }
}
