package com.mfaarihihsan.mywatchlist.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeriesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "episodes")
    private Integer episodes;

    @Column(name = "casts")
    @ManyToMany(mappedBy = "series", fetch = FetchType.LAZY)
    private List<ActorSeriesModel> casts;
}
