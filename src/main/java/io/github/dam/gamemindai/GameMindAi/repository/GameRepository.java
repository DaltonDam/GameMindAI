package io.github.dam.gamemindai.GameMindAi.repository;

import io.github.dam.gamemindai.GameMindAi.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
