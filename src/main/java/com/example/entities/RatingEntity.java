package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "RATING") // Matches the table name in the database
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`value`")
    private String value;

    private String source;

    @ManyToOne
    @JoinColumn(name = "imdbID", referencedColumnName = "imdbID")
    @JsonIgnore
    private MovieEntity movie;
}

