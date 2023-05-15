package com.mfaarihihsan.mywatchlist.service;

import com.mfaarihihsan.mywatchlist.model.SeriesModel;
import com.mfaarihihsan.mywatchlist.payload.request.PaginationRequest;
import com.mfaarihihsan.mywatchlist.payload.request.series.CreateSeriesRequest;
import com.mfaarihihsan.mywatchlist.payload.request.series.UpdateSeriesRequest;
import com.mfaarihihsan.mywatchlist.payload.response.PaginationResponse;
import com.mfaarihihsan.mywatchlist.payload.response.movie.DetailMovieResponse;
import com.mfaarihihsan.mywatchlist.payload.response.series.DetailSeriesResponse;
import com.mfaarihihsan.mywatchlist.payload.response.series.ListSeriesResponse;
import com.mfaarihihsan.mywatchlist.payload.response.series.SeriesResponse;

public interface SeriesService {
    public ListSeriesResponse getListSeries(PaginationRequest paginationRequest);
    public ListSeriesResponse searchSeries(String title, PaginationRequest paginationRequest);
    public DetailSeriesResponse createSeries(CreateSeriesRequest createSeriesRequest);
    public DetailSeriesResponse updateSeries(UpdateSeriesRequest updateSeriesRequest);
    public DetailSeriesResponse getDetailSeries(Integer id);
}
