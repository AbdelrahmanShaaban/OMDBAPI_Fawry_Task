package com.example.services;

import com.example.ExceptionHandling.CustomException;
import com.example.model.Movies;
import com.example.model.MoviesResponse;
import com.example.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class MoviesService {

    private final WebClient webClient;
    @Autowired
    private MoviesRepository moviesRepository;

    private static final String API_KEY = "4f574a38";

    public MoviesService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://www.omdbapi.com")
                .build();
    }

    public MoviesResponse getMovies(String searchQuery, int page) {
        try {
            return webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("s", searchQuery)
                            .queryParam("apikey", API_KEY)
                            .queryParam("page", page)
                            .build())
                    .retrieve()
                    .bodyToMono(MoviesResponse.class)
                    .block();
        } catch (WebClientResponseException ex) {
            throw new CustomException.GeneralException("Error fetching movies: " + ex.getMessage());
        } catch (Exception ex) {
            throw new CustomException.GeneralException("An unexpected error occurred while fetching movies");
        }
    }

    public Movies getMovieDetails(String imdbID) {
        try {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("i", imdbID)
                        .queryParam("apikey", API_KEY)
                        .build())
                .retrieve()
                .bodyToMono(Movies.class)
                .block();
    } catch (WebClientResponseException ex) {
            throw new CustomException.MovieNotFoundException("Error fetching movie details for ID " + imdbID + ": " + ex.getMessage());
        } catch (Exception ex) {
            throw new CustomException.GeneralException("An unexpected error occurred while fetching movie details");
        }

}
}