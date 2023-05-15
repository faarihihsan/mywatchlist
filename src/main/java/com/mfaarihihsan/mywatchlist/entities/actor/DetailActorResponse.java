package com.mfaarihihsan.mywatchlist.entities.actor;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DetailActorResponse extends ActorResponse{
    @JsonProperty("movies")
    private List<ActorMovieResponse> movieResponseList;

    @JsonProperty("series")
    private List<ActorSeriesResponse> seriesResponseList;

    public DetailActorResponse(Integer actorId, String name, List<ActorMovieResponse> movieResponseList, List<ActorSeriesResponse> seriesResponseList) {
        super(actorId, name);
        this.movieResponseList = movieResponseList;
        this.seriesResponseList = seriesResponseList;
    }
}
