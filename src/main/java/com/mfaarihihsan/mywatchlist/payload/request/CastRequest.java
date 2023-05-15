package com.mfaarihihsan.mywatchlist.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastRequest {
    @JsonProperty("actorId")
    private Integer actorId;

    @JsonProperty("character")
    private String character;
}
