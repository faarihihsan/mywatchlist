package com.mfaarihihsan.mywatchlist.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "casts")
    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<ActorMovieModel> casts;

}
