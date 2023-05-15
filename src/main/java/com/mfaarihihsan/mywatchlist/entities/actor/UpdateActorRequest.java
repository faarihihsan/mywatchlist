package com.mfaarihihsan.mywatchlist.entities.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UpdateActorRequest {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;
}
