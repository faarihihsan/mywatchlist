package com.mfaarihihsan.mywatchlist.repositories;

import com.mfaarihihsan.mywatchlist.models.ActorMovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorMovieDb extends JpaRepository<ActorMovieModel, Integer> {
}
