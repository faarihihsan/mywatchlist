package com.mfaarihihsan.mywatchlist.entities.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.entities.CastResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CastMovieResponse extends CastResponse {
    @JsonProperty("character")
    private String character;

    @JsonProperty("isMain")
    private boolean isMain;

    @JsonProperty("isSupport")
    private boolean isSupport;

    @JsonProperty("isGuest")
    private boolean isGuest;

    public CastMovieResponse(Integer id, String name, Integer actorId, String character, boolean isMain, boolean isSupport, boolean isGuest) {
        super(id, name, actorId);
        this.character = character;
        this.isMain = isMain;
        this.isSupport = isSupport;
        this.isGuest = isGuest;
    }
}
