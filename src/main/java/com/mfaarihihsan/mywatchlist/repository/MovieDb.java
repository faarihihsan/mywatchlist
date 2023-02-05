package com.mfaarihihsan.mywatchlist.repository;

import com.mfaarihihsan.mywatchlist.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieDb extends JpaRepository<MovieModel, Integer> {
    Optional<MovieModel> findMovieModelByTitle(String title);
}
