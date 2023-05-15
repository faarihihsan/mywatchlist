package com.mfaarihihsan.mywatchlist.entities.series;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DetailSeriesResponse extends SeriesResponse{
    @JsonProperty("casts")
    private List<CastSeriesResponse> casts;

    public DetailSeriesResponse(Integer seriesId, String title, Integer year, Float rating, Integer episodes, List<CastSeriesResponse> casts) {
        super(seriesId, title, year, rating, episodes);
        this.casts = casts;
    }
}
