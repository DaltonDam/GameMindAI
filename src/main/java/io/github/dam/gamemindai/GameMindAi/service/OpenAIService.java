package io.github.dam.gamemindai.GameMindAi.service;

import io.github.dam.gamemindai.GameMindAi.model.Game;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OpenAIService {

    private final WebClient webClient;

    public OpenAIService(WebClient webClient) {
        this.webClient = webClient;
    }

    private String apiKey = System.getenv("KEY");

    public Mono<String> generateRecipe(List<Game> gameList) {
        String games = gameList.stream()
                .map(game -> String.format(
                        "Nome: %s, Gênero: %s, Plataforma: %s, Lançamento: %s",
                        game.getName(),
                        game.getGenre().name(),
                        game.getPlatform(),
                        game.getRelease()
                ))
                .collect(Collectors.joining("\n"));

        String prompt = "Baseado no meu banco de dados, dê sugestões de jogos semelhantes a essa lista: ." + games;

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4.1",
                "messages", List.of(
                        Map.of("role", "system", "content", "Fale como um profissional de vídeo-games."),
                        Map.of("role", "user", "content", prompt)
                )
        );

        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices != null && !choices.isEmpty()) {
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return message.get("content").toString();
                    }
                    return "Nenhuma sugestão gerada.";
                });
    }



}
