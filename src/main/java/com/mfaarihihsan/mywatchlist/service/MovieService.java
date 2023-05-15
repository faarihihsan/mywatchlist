package com.mfaarihihsan.mywatchlist.service;

import com.mfaarihihsan.mywatchlist.model.MovieModel;
import com.mfaarihihsan.mywatchlist.payload.request.PaginationRequest;
import com.mfaarihihsan.mywatchlist.payload.request.movie.CreateMovieRequest;
import com.mfaarihihsan.mywatchlist.payload.request.movie.UpdateMovieRequest;
import com.mfaarihihsan.mywatchlist.payload.response.movie.DetailMovieResponse;
import com.mfaarihihsan.mywatchlist.payload.response.movie.ListMovieResponse;
import com.mfaarihihsan.mywatchlist.payload.response.movie.MovieResponse;

public interface MovieService {
    public ListMovieResponse getListMovie(PaginationRequest paginationRequest);
    public ListMovieResponse searchMovie(String title, PaginationRequest paginationRequest);
    public DetailMovieResponse createMovie(CreateMovieRequest createMovieRequest);
    public DetailMovieResponse updateMovie(UpdateMovieRequest updateMovieRequest);
    public DetailMovieResponse getDetailMovie(Integer id);
}
