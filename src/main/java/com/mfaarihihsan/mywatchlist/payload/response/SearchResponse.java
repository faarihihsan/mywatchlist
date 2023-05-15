package com.mfaarihihsan.mywatchlist.payload.response;

import com.mfaarihihsan.mywatchlist.controller.SeriesController;
import com.mfaarihihsan.mywatchlist.payload.response.movie.MovieResponse;
import com.mfaarihihsan.mywatchlist.payload.response.series.SeriesResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
    private List<MovieResponse> movies;
    private List<SeriesResponse> series;
    private PaginationResponse pagination;
}
