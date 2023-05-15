package com.mfaarihihsan.mywatchlist.entities.movie;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DetailMovieResponse extends MovieResponse{
    @JsonProperty("casts")
    private List<CastMovieResponse> casts;

    public DetailMovieResponse(Integer MovieId, String title, Integer year, Float rating, List<CastMovieResponse> casts) {
        super(MovieId, title, year, rating);
        this.casts = casts;
    }
}
