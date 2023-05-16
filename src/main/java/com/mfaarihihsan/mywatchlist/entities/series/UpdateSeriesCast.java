package com.mfaarihihsan.mywatchlist.entities.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSeriesCast extends CreateSeriesCast {
    @JsonProperty("castId")
    private Integer castId;

    public UpdateSeriesCast(Integer actorId, String character, boolean isMain, boolean isSupport, boolean isGuest, List<Integer> appearOnEpisodes, Integer castId) {
        super(actorId, character, isMain, isSupport, isGuest, appearOnEpisodes);
        this.castId = castId;
    }
}
