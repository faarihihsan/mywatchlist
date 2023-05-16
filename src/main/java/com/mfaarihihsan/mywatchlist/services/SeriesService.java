package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.series.CreateSeries;
import com.mfaarihihsan.mywatchlist.entities.series.UpdateSeries;
import com.mfaarihihsan.mywatchlist.entities.series.DetailSeries;
import com.mfaarihihsan.mywatchlist.entities.series.SeriesList;

public interface SeriesService {
    public SeriesList getListSeries(PaginationRequest paginationRequest);
    public SeriesList searchSeries(String title, PaginationRequest paginationRequest);
    public DetailSeries createSeries(CreateSeries createSeries);
    public DetailSeries updateSeries(UpdateSeries updateSeries);
    public DetailSeries getDetailSeries(Integer id);
}
