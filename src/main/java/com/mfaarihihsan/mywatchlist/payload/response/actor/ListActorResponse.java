package com.mfaarihihsan.mywatchlist.payload.response.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.payload.response.PaginationResponse;
import com.mfaarihihsan.mywatchlist.payload.response.actor.ActorResponse;
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
