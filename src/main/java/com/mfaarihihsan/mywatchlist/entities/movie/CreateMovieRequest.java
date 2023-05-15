package com.mfaarihihsan.mywatchlist.entities.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieRequest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("rating")
    private Float rating;

    @JsonProperty("casts")
    private List<CreateCastMovieRequest> casts;
}
