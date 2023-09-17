package com.example.mongoapp

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@Component
@EnableScheduling
class PlaneFinderPoller(private val repository: AircraftRepository) {
    private val client: WebClient = WebClient.create("http://localhost:7634/aircraft");

    @Scheduled(fixedRate = 1000)
    private fun poll() {
        repository.deleteAll();

        client.get().retrieve()
            .bodyToFlux<Aircraft>()
            .filter { !it.reg.isNullOrEmpty() }
            .toStream()
            .forEach(repository::save)

        repository.findAll().forEach{ println(it)}
    }
}