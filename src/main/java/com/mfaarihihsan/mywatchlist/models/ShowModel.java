package com.mfaarihihsan.mywatchlist.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "casts")
    @OneToMany(mappedBy = "show", fetch = FetchType.LAZY)
    private List<ActorShowModel> casts;


}
