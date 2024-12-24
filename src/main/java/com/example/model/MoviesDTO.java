package com.example.model;

import com.example.entities.MovieEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MoviesDTO {
    @JsonProperty("imdbID")
    private String imdbID;
    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Type")

    private String Type;
    @JsonProperty("Year")

    private String Year;
    @JsonProperty("Poster")

    private String Poster;
}
