
package com.example.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MoviesResponse {
    @JsonProperty("Response")
    private String Response;
    private String totalResults;
    @JsonProperty("Search")
    private List<MoviesDTO> Search;

}


