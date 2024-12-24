package com.example.services;

import com.example.ExceptionHandling.CustomException;
import com.example.entities.MovieEntity;
import com.example.mapper.MovieMapper;
import com.example.model.Movies;
import com.example.model.MoviesDTO;
import com.example.model.Response;
import com.example.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MoviesRepository moviesRepository;
    public ResponseEntity<?> getAllMovies() {
        List<MovieEntity> allMovies = moviesRepository.findAll();

        if (allMovies.isEmpty()) {
            throw new CustomException.MovieNotFoundException("No movies found in the database");
        }

        return ResponseEntity.ok(new Response(200, "Get All Movies Successfully", allMovies));

    }

    public ResponseEntity<?> getMovieById(String movieId) {
        Optional<MovieEntity> movieEntity = moviesRepository.findById(movieId);

        if (movieEntity.isEmpty()) {
            throw new CustomException.MovieNotFoundException("Movie ID " + movieId + " does not exist in the database");
        }
        Movies moviesDTO = movieMapper.toMovieDTO(movieEntity.get());

        return ResponseEntity.ok(new Response(200, "Get Movie Successfully", moviesDTO));
    }
}
