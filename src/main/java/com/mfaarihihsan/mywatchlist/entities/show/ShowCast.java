package com.mfaarihihsan.mywatchlist.entities.show;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.entities.Cast;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ShowCast extends Cast {
    @JsonProperty("character")
    private String character;

    @JsonProperty("isMember")
    private String isMember;

    @JsonProperty("isGuest")
    private boolean isGuest;

    @JsonProperty("appearOnEpisodes")
    private List<Integer> appearOnEpisodes;

    public ShowCast(Integer castId, String name, Integer actorId, String character, String isMember, boolean isGuest, List<Integer> appearOnEpisodes) {
        super(castId, name, actorId);
        this.character = character;
        this.isMember = isMember;
        this.isGuest = isGuest;
        this.appearOnEpisodes = appearOnEpisodes;
    }
}
