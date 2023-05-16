package com.mfaarihihsan.mywatchlist.entities.show;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {
    @JsonProperty("showId")
    private Integer showId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("yearStart")
    private Integer yearStart;

    @JsonProperty("yearEnd")
    private Integer yearEnd;

    @JsonProperty("isContinue")
    private boolean isContinue;

    @JsonProperty("rating")
    private Float rating;

    @JsonProperty("episodes")
    private Integer episodes;
}
