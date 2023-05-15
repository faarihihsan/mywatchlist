package com.mfaarihihsan.mywatchlist.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    private List<ActorMovieModel> movies;

    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    private List<ActorSeriesModel> series;

    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    private List<ActorShowModel> shows;

    public ActorModel(String name) {
        this.name = name;
    }
}
