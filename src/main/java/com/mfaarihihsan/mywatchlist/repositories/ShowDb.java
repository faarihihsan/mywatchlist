package com.mfaarihihsan.mywatchlist.repositories;

import com.mfaarihihsan.mywatchlist.models.ShowModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShowDb extends JpaRepository<ShowModel, Integer> {
    @Query(value = "SELECT sm FROM ShowModel sm WHERE lower(sm.title) LIKE %:title%")
    Page<ShowModel> findShowModelByTitle(@Param("title") String title, Pageable pageable);
}
