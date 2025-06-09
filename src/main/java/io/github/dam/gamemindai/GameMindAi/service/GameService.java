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

    public Optional<Game> listById(Long id) {
        return repository.findById(id);
    }

    public Game update(Long id, Game gameUpdated) {
        if(repository.existsById(id)) {
            gameUpdated.setId(id);
            return repository.save(gameUpdated);
        }
        return null;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
