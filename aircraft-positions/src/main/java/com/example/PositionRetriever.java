package com.example;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

@AllArgsConstructor
@Configuration
public class PositionRetriever {
    private final AirCraftRepository repo;
    private final WebSocketHandler handler;

    @Bean
    Consumer<List<AirCraft>> retrieveAircraftPositions() {
        return acList -> {
            repo.deleteAll();

            repo.saveAll(acList);

            repo.findAll().forEach(System.out::println);
            sendPositions();
        };
    }

    private void sendPositions() {
        if (repo.count() > 0) {
            for (WebSocketSession sessionInList : handler.getSessionList()) {
                try {
                    sessionInList.sendMessage(new TextMessage(repo.findAll().toString()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
