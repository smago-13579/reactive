package com.example.sburredis;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
public class PlaneFinderPoller {
    private WebClient client = WebClient.create("http://localhost:7634/aircraft");
    private final AircraftRepository aircraftRepository;
    private final RedisConnectionFactory factory;

    public PlaneFinderPoller(AircraftRepository aircraftRepository, RedisConnectionFactory factory) {
        this.aircraftRepository = aircraftRepository;
        this.factory = factory;
    }

    @Scheduled(fixedRate = 1000)
    private void pollPlanes() {
//        factory.getConnection().serverCommands().flushDb();

        client.get()
                .retrieve()
                .bodyToFlux(AirCraft.class)
                .filter(airCraft -> !airCraft.getReg().isEmpty())
                .toStream()
                .forEach(aircraftRepository::save);

        aircraftRepository.findAll().forEach(System.out::println);
    }
}
