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
public class ActorShowModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private ActorModel actor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "show_id")
    private ShowModel show;

    @Column(name = "isMember")
    private boolean isMember;

    @Column(name = "isExMember")
    private boolean isExMember;

    @Column(name = "isGuest")
    private boolean isGuest;

    @Column(name = "appear_on_episodes")
    @ElementCollection
    private List<Integer> appear_on_episodes;
}
