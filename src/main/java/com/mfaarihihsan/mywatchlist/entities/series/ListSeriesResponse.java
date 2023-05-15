package com.mfaarihihsan.mywatchlist.entities.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfaarihihsan.mywatchlist.entities.PaginationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListSeriesResponse {
    @JsonProperty("series")
    private List<SeriesResponse> series;

    @JsonProperty("pagination")
    private PaginationResponse pagination;
}
