package com.mfaarihihsan.mywatchlist.repository;

import com.mfaarihihsan.mywatchlist.model.ActorModel;
import com.mfaarihihsan.mywatchlist.model.ActorSeriesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActorDb extends JpaRepository<ActorModel, Integer> {
    Optional<List<ActorModel>> findActorModelsByName(String name);
}

