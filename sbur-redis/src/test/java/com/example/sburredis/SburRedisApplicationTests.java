package com.example.sburredis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//@SpringBootTest
class SburRedisApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(LocalDateTime.now().toLocalDate().compareTo(LocalDate.now().minusDays(1)));
    }

    @Test
    void someTest() {
        List<Order> orders = List.of(new Order(1L), new Order(2L), new Order(3L));

        Order sorted = orders.stream().min((a1, a2) -> Math.toIntExact(a1.id() - a2.id())).get();

        System.out.println(sorted);
    }

    record Order(Long id) {}

}
