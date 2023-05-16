package com.mfaarihihsan.mywatchlist.entities.show;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.PaginationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowList {
    @JsonProperty("shows")
    private List<Show> shows;

    @JsonProperty("pagination")
    private PaginationResponse pagination;
}
