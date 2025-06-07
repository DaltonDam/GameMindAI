package io.github.dam.gamemindai.GameMindAi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "game")
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private GameGenre genre;

    private String platform;


}
