package com.mfaarihihsan.mywatchlist.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponse {
    @JsonProperty("page")
    private Integer page;

    @JsonProperty("itemPerPage")
    private Integer itemPerPage;

    @JsonProperty("totalPage")
    private Integer totalPage;

    @JsonProperty("totalItem")
    private Long totalItem;
}
