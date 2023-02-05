package com.mfaarihihsan.mywatchlist.model;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private ActorModel actor;

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
