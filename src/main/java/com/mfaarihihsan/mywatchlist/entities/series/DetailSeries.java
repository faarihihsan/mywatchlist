package com.mfaarihihsan.mywatchlist.entities.series;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DetailSeries extends Series {
    @JsonProperty("casts")
    private List<SeriesCast> casts;

    public DetailSeries(Integer seriesId, String title, Integer year, Float rating, Integer episodes, List<SeriesCast> casts) {
        super(seriesId, title, year, rating, episodes);
        this.casts = casts;
    }
}
