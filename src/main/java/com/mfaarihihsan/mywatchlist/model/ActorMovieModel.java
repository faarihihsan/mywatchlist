package com.mfaarihihsan.mywatchlist.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorMovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private MovieModel movie;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private ActorModel actor;

    @Column(name = "character")
    private String character;

    @Column(name = "isMain")
    private boolean isMain;

    @Column(name = "isSupport")
    private boolean isSupport;

    @Column(name = "isGuest")
    private boolean isGuest;
}
