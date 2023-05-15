package com.mfaarihihsan.mywatchlist.payload.response.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.payload.response.PaginationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListMovieResponse {
    @JsonProperty("movies")
    private List<MovieResponse> movies;

    @JsonProperty("pagination")
    private PaginationResponse pagination;
}
