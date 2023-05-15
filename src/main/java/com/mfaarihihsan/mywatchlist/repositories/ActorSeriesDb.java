package com.mfaarihihsan.mywatchlist.repositories;

import com.mfaarihihsan.mywatchlist.models.ActorSeriesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorSeriesDb extends JpaRepository<ActorSeriesModel, Integer> {
}
