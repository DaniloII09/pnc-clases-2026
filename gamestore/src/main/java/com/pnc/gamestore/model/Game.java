package com.pnc.gamestore.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "video_games")
public class Game {
    @Id
    @Column
    public Integer id;

    @Column(nullable = false)
    public String name;

    @Column
    public String genre;

    @Column
    public String classification;

    @Column(name = "game_developer")
    public String dev;

    @OneToOne(mappedBy = "game")
    public GameDetails details;

    @OneToMany(mappedBy = "game")
    public List<Reviews> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "game_platforms",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    public List<Platforms> platforms = new ArrayList<>();

    public Game() {
    }

    public Game(Integer id, String name, String genre, String classification, String dev) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.classification = classification;
        this.dev = dev;
    }
}