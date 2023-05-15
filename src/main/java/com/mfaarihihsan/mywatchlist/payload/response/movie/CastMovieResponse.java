package com.mfaarihihsan.mywatchlist.payload.response.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.payload.response.CastResponse;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
