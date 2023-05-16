package com.mfaarihihsan.mywatchlist.entities.show;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UpdateShow {
    @JsonProperty("showId")
    private Integer showId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("rating")
    private Float rating;

    @JsonProperty("episodes")
    private Integer episodes;

    @JsonProperty("casts")
    private List<UpdateShowCast> casts;
}
