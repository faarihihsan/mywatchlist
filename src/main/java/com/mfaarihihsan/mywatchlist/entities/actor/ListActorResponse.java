package com.mfaarihihsan.mywatchlist.entities.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.entities.PaginationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListActorResponse {
    @JsonProperty("actors")
    private List<ActorResponse> actors;

    @JsonProperty("pagination")
    private PaginationResponse pagination;
}
