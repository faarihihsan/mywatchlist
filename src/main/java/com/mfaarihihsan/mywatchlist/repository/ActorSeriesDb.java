package com.mfaarihihsan.mywatchlist.repository;

import com.mfaarihihsan.mywatchlist.model.ActorSeriesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorSeriesDb extends JpaRepository<ActorSeriesModel, Integer> {
}
