package com.mfaarihihsan.mywatchlist.entities.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    @JsonProperty("movieId")
    private Integer MovieId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("rating")
    private Float rating;

}
