package com.example.controller;

import com.example.entities.MovieEntity;
import com.example.services.MoviesService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllMovies")
    public ResponseEntity<?> getAllMovies() {
        return userService.getAllMovies();
    }

    @GetMapping("/getMoviesById")
    public ResponseEntity<?> getMoviesById(@RequestParam String movieId) {
        return userService.getMovieById(movieId);
    }

}
