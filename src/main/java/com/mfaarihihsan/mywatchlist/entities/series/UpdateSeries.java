package com.mfaarihihsan.mywatchlist.entities.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpdateSeries {
    @JsonProperty("seriesId")
    private Integer seriesId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("rating")
    private Float rating;

    @JsonProperty("episodes")
    private Integer episodes;

    @JsonProperty("casts")
    private List<UpdateSeriesCast> casts;

}
