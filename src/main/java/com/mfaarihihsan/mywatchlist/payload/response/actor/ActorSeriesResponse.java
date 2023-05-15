package com.mfaarihihsan.mywatchlist.payload.response.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorSeriesResponse {
    @JsonProperty("actorId")
    private Integer actorId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("seriesId")
    private Integer seriesId;

    @JsonProperty("character")
    private String character;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("isMain")
    private boolean isMain;

    @JsonProperty("isSupport")
    private boolean isSupport;

    @JsonProperty("isGuest")
    private boolean isGuest;
}
