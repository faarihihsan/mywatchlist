package com.mfaarihihsan.mywatchlist.payload.response.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.payload.response.CastResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CastSeriesResponse extends CastResponse {
    @JsonProperty("character")
    private String character;

    @JsonProperty("isMain")
    private boolean isMain;

    @JsonProperty("isSupport")
    private boolean isSupport;

    @JsonProperty("isGuest")
    private boolean isGuest;

    @JsonProperty("appearOnEpisodes")
    private List<Integer> appearOnEpisodes;


    public CastSeriesResponse(Integer id, String name, Integer actorId, String character, boolean isMain, boolean isSupport, boolean isGuest, List<Integer> appearOnEpisodes) {
        super(id, name, actorId);
        this.character = character;
        this.isMain = isMain;
        this.isSupport = isSupport;
        this.isGuest = isGuest;
        this.appearOnEpisodes = appearOnEpisodes;
    }
}
