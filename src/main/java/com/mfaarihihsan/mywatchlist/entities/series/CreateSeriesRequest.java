package com.mfaarihihsan.mywatchlist.entities.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSeriesRequest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("rating")
    private Float rating;

    @JsonProperty("episodes")
    private Integer episodes;

    @JsonProperty("casts")
    private List<CreateCastSeriesRequest> casts;
}
