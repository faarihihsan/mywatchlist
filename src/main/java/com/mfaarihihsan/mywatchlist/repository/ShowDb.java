package com.mfaarihihsan.mywatchlist.repository;

import com.mfaarihihsan.mywatchlist.model.ShowModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowDb extends JpaRepository<ShowModel, Integer> {
    Optional<ShowModel> findShowModelByTitle(String title);
}
