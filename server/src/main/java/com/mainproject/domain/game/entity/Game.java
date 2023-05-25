package com.mainproject.domain.game.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    @Column(nullable = false)
    private String title;

    @Column
    private String gameRank;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String publisher;

    @Column
    private String description;

    @Column
    private String imageUrl;

    public Game(String title, String gameRank, String genre, String publisher, String description, String imageUrl) {
        this.title = title;
        this.gameRank = gameRank;
        this.genre = genre;
        this.publisher = publisher;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
