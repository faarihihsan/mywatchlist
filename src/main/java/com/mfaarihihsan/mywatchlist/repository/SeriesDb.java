package com.mfaarihihsan.mywatchlist.repository;

import com.mfaarihihsan.mywatchlist.model.SeriesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeriesDb extends JpaRepository<SeriesModel, Integer> {
    Optional<SeriesModel> findSeriesModelByTitle(String title);
}
