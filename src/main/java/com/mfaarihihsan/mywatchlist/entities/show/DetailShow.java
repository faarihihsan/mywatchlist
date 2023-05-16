package com.mfaarihihsan.mywatchlist.entities.show;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DetailShow extends Show{
    @JsonProperty("casts")
    private List<ShowCast> casts;

    public DetailShow(Integer showId, String title, Integer yearStart, Integer yearEnd, boolean isContinue, Float rating, Integer episodes, List<ShowCast> casts) {
        super(showId, title, yearStart, yearEnd, isContinue, rating, episodes);
        this.casts = casts;
    }
}
