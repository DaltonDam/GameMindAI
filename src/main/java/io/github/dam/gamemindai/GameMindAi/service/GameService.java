package io.github.dam.gamemindai.GameMindAi.service;

import io.github.dam.gamemindai.GameMindAi.model.Game;
import io.github.dam.gamemindai.GameMindAi.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public Game save(Game game) {
        return repository.save(game);
    }

    public List<Game> list() {
        return repository.findAll();
    }

    public Optional<Game> findById(Long id) {
        return repository.findById(id);
    }

    public Game update(Game game) {
        return repository.save(game);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
