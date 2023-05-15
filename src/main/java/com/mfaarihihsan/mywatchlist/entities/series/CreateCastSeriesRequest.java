package com.mfaarihihsan.mywatchlist.entities.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.entities.CastRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCastSeriesRequest extends CastRequest {
    @JsonProperty("isMain")
    private boolean isMain;

    @JsonProperty("isSupport")
    private boolean isSupport;

    @JsonProperty("isGuest")
    private boolean isGuest;

    @JsonProperty("appearOnEpisodes")
    private List<Integer> appearOnEpisodes;

    public CreateCastSeriesRequest(Integer actorId, String character, boolean isMain, boolean isSupport, boolean isGuest, List<Integer> appearOnEpisodes) {
        super(actorId, character);
        this.isMain = isMain;
        this.isSupport = isSupport;
        this.isGuest = isGuest;
        this.appearOnEpisodes = appearOnEpisodes;
    }
}
