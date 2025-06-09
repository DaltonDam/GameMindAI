package io.github.dam.gamemindai.GameMindAi.controller;

import io.github.dam.gamemindai.GameMindAi.model.Game;
import io.github.dam.gamemindai.GameMindAi.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameService service;

    public GameController(GameService gameService) {
        this.service = gameService;
    }

    //POST
    public ResponseEntity<Game> save(@RequestBody Game game) {
        Game saved = service.save(game);
        return ResponseEntity.ok(saved);
    }

    //GET
    public ResponseEntity<List<Game>> list() {
        List<Game> listed = service.list();
        return ResponseEntity.ok(listed);
    }

    //UPDATE

    //DELETE

}
