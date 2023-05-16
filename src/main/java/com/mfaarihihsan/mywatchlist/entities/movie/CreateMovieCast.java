package com.mfaarihihsan.mywatchlist.entities.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.entities.CreateCast;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateMovieCast extends CreateCast {
    @JsonProperty("isMain")
    private boolean isMain;

    @JsonProperty("isSupport")
    private boolean isSupport;

    @JsonProperty("isGuest")
    private boolean isGuest;

    public CreateMovieCast(Integer actorId, String character, boolean isMain, boolean isSupport, boolean isGuest) {
        super(actorId, character);
        this.isMain = isMain;
        this.isSupport = isSupport;
        this.isGuest = isGuest;
    }
}
