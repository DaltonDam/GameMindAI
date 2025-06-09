package io.github.dam.gamemindai.GameMindAi.controller;

import io.github.dam.gamemindai.GameMindAi.model.Game;
import io.github.dam.gamemindai.GameMindAi.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameService service;

    public GameController(GameService gameService) {
        this.service = gameService;
    }

    //POST
    @PostMapping
    public ResponseEntity<Game> save(@RequestBody Game game) {
        Game saved = service.save(game);
        return ResponseEntity.ok(saved);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<Game>> list() {
        List<Game> listed = service.list();
        return ResponseEntity.ok(listed);
    }

    //UPDATE
    @PutMapping
    public ResponseEntity<Game> update(@RequestBody Game game, @PathVariable Long id) {
        return service.findById(id)
                .map(existingGame -> {
                    game.setId(existingGame.getId());
                    Game updated = service.update(game);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    //DELETE
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
