package com.mfaarihihsan.mywatchlist.repositories;

import com.mfaarihihsan.mywatchlist.models.ActorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActorDb extends JpaRepository<ActorModel, Integer> {
    @Query(value = "SELECT am FROM ActorModel am WHERE lower(am.name) LIKE %:name%")
    Page<ActorModel> findActorModelsByName(@Param("name") String name, Pageable pageable);
}

