package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.movie.CreateMovieRequest;
import com.mfaarihihsan.mywatchlist.entities.movie.UpdateMovieRequest;
import com.mfaarihihsan.mywatchlist.entities.movie.DetailMovieResponse;
import com.mfaarihihsan.mywatchlist.entities.movie.ListMovieResponse;

public interface MovieService {
    public ListMovieResponse getListMovie(PaginationRequest paginationRequest);
    public ListMovieResponse searchMovie(String title, PaginationRequest paginationRequest);
    public DetailMovieResponse createMovie(CreateMovieRequest createMovieRequest);
    public DetailMovieResponse updateMovie(UpdateMovieRequest updateMovieRequest);
    public DetailMovieResponse getDetailMovie(Integer id);
}
