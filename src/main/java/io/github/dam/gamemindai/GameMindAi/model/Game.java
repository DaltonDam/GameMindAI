package io.github.dam.gamemindai.GameMindAi.model;

import io.github.dam.gamemindai.GameMindAi.enums.GameGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "game")
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private GameGenre genre;

    @Column(name = "platform")
    private String platform;

    @Column(name = "release")
    private LocalDate release;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameGenre getGenre() {
        return genre;
    }

    public void setGenre(GameGenre genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }
}
