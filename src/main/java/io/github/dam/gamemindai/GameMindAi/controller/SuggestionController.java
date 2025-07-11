package io.github.dam.gamemindai.GameMindAi.controller;

import io.github.dam.gamemindai.GameMindAi.model.Game;
import io.github.dam.gamemindai.GameMindAi.service.GameService;
import io.github.dam.gamemindai.GameMindAi.service.OpenAIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class SuggestionController {

    private GameService gameService;
    private OpenAIService openAIService;

    public SuggestionController(GameService gameService, OpenAIService openAIService) {
        this.gameService = gameService;
        this.openAIService = openAIService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateSuggestion() {
        List<Game> gameList = gameService.list();
        return openAIService.generateRecipe(gameList)
                .map(suggestion -> ResponseEntity.ok(suggestion))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
