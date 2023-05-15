package com.mfaarihihsan.mywatchlist.payload.response.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeriesResponse {
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

}
