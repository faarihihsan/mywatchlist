package com.mfaarihihsan.mywatchlist.entities.actor;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DetailActor extends Actor {
    @JsonProperty("movies")
    private List<MovieActor> movieResponseList;

    @JsonProperty("series")
    private List<SeriesActor> seriesResponseList;

    public DetailActor(Integer actorId, String name, List<MovieActor> movieResponseList, List<SeriesActor> seriesResponseList) {
        super(actorId, name);
        this.movieResponseList = movieResponseList;
        this.seriesResponseList = seriesResponseList;
    }
}
