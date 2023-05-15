package com.mfaarihihsan.mywatchlist.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastResponse {
    @JsonProperty("castId")
    private Integer castId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("actorId")
    private Integer actorId;
}
