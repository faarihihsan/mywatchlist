package com.mfaarihihsan.mywatchlist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private ActorModel actor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "series_id")
    private SeriesModel series;

    @Column(name = "character")
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
