package com.mfaarihihsan.mywatchlist.entities.show;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateShowCast extends CreateShowCast{
    @JsonProperty("castId")
    private Integer castId;

    public UpdateShowCast(boolean isMember, boolean isGuest, List<Integer> appearOnEpisodes, Integer castId) {
        super(isMember, isGuest, appearOnEpisodes);
        this.castId = castId;
    }
}
