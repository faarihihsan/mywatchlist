package com.mfaarihihsan.mywatchlist.entities.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorResponse {
    @JsonProperty("actorId")
    private Integer actorId;

    @JsonProperty("name")
    private String name;
}
