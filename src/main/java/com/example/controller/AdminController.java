package com.example.controller;

import com.example.entities.MovieEntity;
import com.example.model.MoviesDTO;
import com.example.model.MoviesResponse;
import com.example.model.Response;
import com.example.services.AdminService;
import com.example.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private MoviesService moviesService;

    @PostMapping("/insertMovies")
    public ResponseEntity<?> insertMovies(@RequestBody List<MoviesDTO> MoviesDTO) {
        return adminService.insertListOfMovies(MoviesDTO);

    }

    @PostMapping("/deleteMovies")
    public ResponseEntity<?> deleteMovies(@RequestBody List<String> movieId) {
        return adminService.deleteMoviesByIds(movieId);
    }

    @GetMapping("/getMovie")
    public ResponseEntity<?> getMovies(@RequestParam String searchQuery, @RequestParam Integer page) {
        MoviesResponse movies = moviesService.getMovies(searchQuery, page);
        return ResponseEntity.ok(new Response(200, "Get Movies Successfully", movies));
    }
}
