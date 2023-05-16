package com.mfaarihihsan.mywatchlist.entities;

import com.mfaarihihsan.mywatchlist.entities.movie.Movie;
import com.mfaarihihsan.mywatchlist.entities.series.Series;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
    private List<Movie> movies;
    private List<Series> series;
    private PaginationResponse pagination;
}
