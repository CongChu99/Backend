package com.example.MovieTicket.controller;

import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MovieController {

    @Autowired
    private IMovieService movieService;

    // get all movie
    @GetMapping("api/v1/movie")
    public List<Movie> findAll() {
        List<Movie> movies = movieService.findAll();
        return movies;
    }

    @PostMapping("api/v1/movie")
    public void createMovie(@RequestBody Movie movie){
        movieService.createOrUpdateMovie(movie);
    }

    @PutMapping("api/v1/movie")
    public void updateMovie(@RequestBody Movie movie){
        movieService.createOrUpdateMovie(movie);
    }

    @DeleteMapping("api/v1/movie")
    public void deleteById(@RequestParam int id){
        movieService.deleteById(id);
    }
}
