package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.series.CreateSeriesRequest;
import com.mfaarihihsan.mywatchlist.entities.series.UpdateSeriesRequest;
import com.mfaarihihsan.mywatchlist.entities.series.DetailSeriesResponse;
import com.mfaarihihsan.mywatchlist.entities.series.ListSeriesResponse;

public interface SeriesService {
    public ListSeriesResponse getListSeries(PaginationRequest paginationRequest);
    public ListSeriesResponse searchSeries(String title, PaginationRequest paginationRequest);
    public DetailSeriesResponse createSeries(CreateSeriesRequest createSeriesRequest);
    public DetailSeriesResponse updateSeries(UpdateSeriesRequest updateSeriesRequest);
    public DetailSeriesResponse getDetailSeries(Integer id);
}
