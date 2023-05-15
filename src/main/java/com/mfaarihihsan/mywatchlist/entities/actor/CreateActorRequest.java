package com.mfaarihihsan.mywatchlist.entities.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateActorRequest {
    @JsonProperty("name")
    private String name;

}
