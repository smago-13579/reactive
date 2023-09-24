package com.example.sburredis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@SpringBootTest
class SburRedisApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(LocalDateTime.now().toLocalDate().compareTo(LocalDate.now().minusDays(1)));
    }

}
