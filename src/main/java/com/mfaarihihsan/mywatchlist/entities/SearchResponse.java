package com.mfaarihihsan.mywatchlist.entities;

import com.mfaarihihsan.mywatchlist.entities.movie.MovieResponse;
import com.mfaarihihsan.mywatchlist.entities.series.SeriesResponse;
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
