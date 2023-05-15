package com.mfaarihihsan.mywatchlist.payload.request.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.payload.request.CastRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCastMovieRequest extends CastRequest {
    @JsonProperty("isMain")
    private boolean isMain;

    @JsonProperty("isSupport")
    private boolean isSupport;

    @JsonProperty("isGuest")
    private boolean isGuest;

    public CreateCastMovieRequest(Integer actorId, String character, boolean isMain, boolean isSupport, boolean isGuest) {
        super(actorId, character);
        this.isMain = isMain;
        this.isSupport = isSupport;
        this.isGuest = isGuest;
    }
}
