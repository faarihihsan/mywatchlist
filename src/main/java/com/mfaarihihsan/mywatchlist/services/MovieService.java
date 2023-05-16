package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.movie.CreateMovie;
import com.mfaarihihsan.mywatchlist.entities.movie.UpdateMovie;
import com.mfaarihihsan.mywatchlist.entities.movie.DetailMovie;
import com.mfaarihihsan.mywatchlist.entities.movie.MovieList;

public interface MovieService {
    public MovieList getListMovie(PaginationRequest paginationRequest);
    public MovieList searchMovie(String title, PaginationRequest paginationRequest);
    public DetailMovie createMovie(CreateMovie createMovie);
    public DetailMovie updateMovie(UpdateMovie updateMovieRequest);
    public DetailMovie getDetailMovie(Integer id);
}
