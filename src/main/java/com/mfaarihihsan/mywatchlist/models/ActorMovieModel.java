package com.mfaarihihsan.mywatchlist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private MovieModel movie;

    @JsonIgnore
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

    @Override
    public String toString() {
        return "ActorMovieModel{" +
                "id=" + id +
                ", movie=" + movie +
                ", actor=" + actor +
                ", character='" + character + '\'' +
                ", isMain=" + isMain +
                ", isSupport=" + isSupport +
                ", isGuest=" + isGuest +
                '}';
    }
}
