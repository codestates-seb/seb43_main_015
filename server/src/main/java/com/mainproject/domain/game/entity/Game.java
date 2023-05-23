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

    public Game(String title, String rank, String genre, String publisher, String description) {
        this.title = title;
        this.gameRank = rank;
        this.genre = genre;
        this.publisher = publisher;
        this.description = description;
    }
}
