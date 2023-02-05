package com.mfaarihihsan.mywatchlist.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorSeriesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private ActorModel actor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "series_id")
    private SeriesModel series;

    @Column(name = "characted")
    private String character;

    @Column(name = "isMain")
    private boolean isMain;

    @Column(name = "isSupport")
    private boolean isSupport;

    @Column(name = "isGuest")
    private boolean isGuest;

    @Column(name = "appear_on_episodes")
    @ElementCollection
    private List<Integer> appear_on_episodes;

}
