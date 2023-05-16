package com.mfaarihihsan.mywatchlist.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCast {
    @JsonProperty("actorId")
    private Integer actorId;

    @JsonProperty("character")
    private String character;
}
