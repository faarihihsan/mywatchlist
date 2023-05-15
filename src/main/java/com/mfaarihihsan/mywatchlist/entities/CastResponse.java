package com.mfaarihihsan.mywatchlist.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
