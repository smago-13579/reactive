package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequiredArgsConstructor
public class PositionController {
    private final AirCraftRepository repository;
    private WebClient webClient = WebClient.create("http://localhost:7634/aircraft");

    @GetMapping("/aircraft")
    public String getAircraftPositions(Model model) {
        repository.deleteAll();

        webClient.get()
                .retrieve()
                .bodyToFlux(AirCraft.class)
                .filter(plane -> !plane.getReg().isEmpty())
                .toStream().forEach(repository::save);

        model.addAttribute("currentPositions", repository.findAll());
        return "positions";
    }
}
