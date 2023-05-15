package com.mfaarihihsan.mywatchlist.repository;

import com.mfaarihihsan.mywatchlist.model.ActorMovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorMovieDb extends JpaRepository<ActorMovieModel, Integer> {
}
