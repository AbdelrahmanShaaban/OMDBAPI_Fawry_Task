package com.example.services;

import com.example.ExceptionHandling.CustomException;
import com.example.entities.MovieEntity;
import com.example.entities.RatingEntity;
import com.example.mapper.MovieMapper;
import com.example.model.Movies;
import com.example.model.MoviesDTO;
import com.example.model.Response;
import com.example.repositories.MoviesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MoviesService moviesService;

    @Transactional
    public ResponseEntity<?> insertListOfMovies(List<MoviesDTO> moviesDTOList) {
        try {
            List<MovieEntity> savedMovies = new ArrayList<>();

            for (MoviesDTO moviesDTO : moviesDTOList) {
                try {
                    Movies movieDetails = moviesService.getMovieDetails(moviesDTO.getImdbID());
                    MovieEntity entity = movieMapper.toMovieEntity(movieDetails);
                    for (RatingEntity rating : entity.getRatings()) {
                        rating.setMovie(entity);
                    }
                    savedMovies.add(entity);
                } catch (Exception ex) {
                    throw new CustomException.GeneralException(
                            "Failed to map and save movie with ID: " + moviesDTO.getImdbID() + ". Reason: " + ex.getMessage());
                }
            }

            moviesRepository.saveAll(savedMovies);
            return ResponseEntity.ok(new Response(200, "Movies inserted successfully", savedMovies));
        } catch (CustomException.GeneralException ex) {
            throw ex; // Let the global exception handler handle it
        } catch (Exception e) {
            throw new CustomException.GeneralException("Error inserting movies: " + e.getMessage());
        }
    }

    @Transactional
    public ResponseEntity<?> deleteMoviesByIds(List<String> movieIds) {
        try {
            List<MovieEntity> moviesToDelete = moviesRepository.findAllById(movieIds);
            if (moviesToDelete.isEmpty()) {
                throw new CustomException.MovieNotFoundException("The movies with the provided IDs do not exist in the database");
            }
            moviesRepository.deleteAll(moviesToDelete);
            return ResponseEntity.ok(new Response(200, "Movies deleted successfully", movieIds));
        } catch (CustomException.MovieNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new CustomException.GeneralException("Error deleting movies: " + e.getMessage());
        }
    }
}
