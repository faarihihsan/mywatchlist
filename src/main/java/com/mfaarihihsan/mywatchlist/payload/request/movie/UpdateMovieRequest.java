package com.mfaarihihsan.mywatchlist.payload.request.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMovieRequest {
    @JsonProperty("movieId")
    private Integer movieId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("rating")
    private Float rating;

    @JsonProperty("casts")
    private List<UpdateCastMovieRequest> casts;
}
