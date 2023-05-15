package com.mfaarihihsan.mywatchlist.repository;

import com.mfaarihihsan.mywatchlist.model.MovieModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieDb extends JpaRepository<MovieModel, Integer> {
    @Query(value = "SELECT sm FROM MovieModel sm WHERE lower(sm.title) LIKE %:title%")
    Page<MovieModel> findMovieModelByTitle(@Param("title") String title, Pageable pageable);

}
