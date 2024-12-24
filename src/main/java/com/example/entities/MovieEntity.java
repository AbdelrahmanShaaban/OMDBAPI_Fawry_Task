package com.example.entities;

import com.example.model.MoviesDTO;
import com.example.model.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Table(name = "MOVIES") // Matches the table name in the database
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {

    @Id
    private String imdbID;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL , fetch = FetchType.LAZY, orphanRemoval = true)
    private List<RatingEntity> ratings;

    private String metascore;
    private String boxOffice;
    private String website;
    private String imdbRating;
    private String imdbVotes;
    private String runtime;
    private String language;
    private String rated;
    private String production;
    private String released;
    private String plot;
    private String director;
    private String title;
    private String actors;
    private String response;
    private String type;
    private String awards;
    private String dvd;
    @Column(name = "'year'")
    private String year;
    private String poster;
    private String country;
    private String genre;
    private String writer;

}
