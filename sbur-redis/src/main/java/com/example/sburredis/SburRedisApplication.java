package com.example.sburredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class SburRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SburRedisApplication.class, args);
    }

    @Bean
    public RedisOperations<String, AirCraft> redisOperations(RedisConnectionFactory factory) {
        RedisTemplate<String, AirCraft> template = new RedisTemplate<>();
        
        Jackson2JsonRedisSerializer<AirCraft> serializer = new Jackson2JsonRedisSerializer<>(AirCraft.class);
        template.setConnectionFactory(factory);
        template.setDefaultSerializer(serializer);
        template.setKeySerializer(new StringRedisSerializer());

        return template;
    }

}
