package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsTest {

    @Test
    void test() {
        List<String> strings = Arrays.asList("one", "two", "three", "four");
        Stream<String> longStringsStream = strings.stream().filter(s -> {
            System.out.println("Filtering: " + s);
            return s.length() > 3;
        });
        System.out.println("Stream created, filter not applied yet!");
        longStringsStream.forEach(System.out::println);


        strings.stream()
                .filter(s -> {
                    System.out.println("Filter: " + s);
                    return s.length() > 3;
                })
                .map(s -> {
                    System.out.println("Map: " + s);
                    return s.toUpperCase();
                }).forEach(s -> System.out.println("Processed: " + s));

        Stream.iterate(0, n -> n + 1)
                .filter(n -> n % 2 == 0)
                .limit(10)
                .forEach(System.out::println);
    }
}
