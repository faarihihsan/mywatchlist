package com.mfaarihihsan.mywatchlist.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationRequest {
    @JsonProperty("page")
    private Integer page;

    @JsonProperty("itemPerPage")
    private Integer itemPerPage;
}