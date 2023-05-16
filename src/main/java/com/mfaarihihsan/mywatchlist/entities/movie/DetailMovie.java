package com.mfaarihihsan.mywatchlist.entities.movie;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DetailMovie extends Movie {
    @JsonProperty("casts")
    private List<MovieCast> casts;

    public DetailMovie(Integer MovieId, String title, Integer year, Float rating, List<MovieCast> casts) {
        super(MovieId, title, year, rating);
        this.casts = casts;
    }
}
