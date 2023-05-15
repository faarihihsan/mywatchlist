package com.mfaarihihsan.mywatchlist.repository;

import com.mfaarihihsan.mywatchlist.model.SeriesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SeriesDb extends JpaRepository<SeriesModel, Integer> {
    @Query(value = "SELECT sm FROM SeriesModel sm WHERE lower(sm.title) LIKE %:title%")
    Page<SeriesModel> findSeriesModelByTitle(@Param("title") String title, Pageable pageable);
}
