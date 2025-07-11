package io.github.dam.gamemindai.GameMindAi.controller;

import io.github.dam.gamemindai.GameMindAi.service.OpenAIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SuggestionController {

    private OpenAIService openAIService;

    public SuggestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateSuggestion() {
        return openAIService.generateRecipe()
                .map(suggestion -> ResponseEntity.ok(suggestion))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
