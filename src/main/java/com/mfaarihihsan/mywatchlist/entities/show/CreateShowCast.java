package com.mfaarihihsan.mywatchlist.entities.show;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateShowCast extends CreateShow {
    @JsonProperty("isMember")
    private boolean isMember;

    @JsonProperty("isGuest")
    private boolean isGuest;

    @JsonProperty("appearOnEpisodes")
    private List<Integer> appearOnEpisodes;

    public CreateShowCast(String title, Integer year, Float rating, Integer episodes, List<CreateShowCast> casts, boolean isMember, boolean isGuest, List<Integer> appearOnEpisodes) {
        super(title, year, rating, episodes, casts);
        this.isMember = isMember;
        this.isGuest = isGuest;
        this.appearOnEpisodes = appearOnEpisodes;
    }
}