package com.example.MovieTicket.controller;

import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.form.MovieCreateOrUpdateForm;
import com.example.MovieTicket.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MovieController {

    @Autowired
    private IMovieService movieService;

    // get all movie
    @GetMapping("api/v1/movie")
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<MovieDTO> movies = movieService.findAll(pageable);
        return movies;
    }

    @GetMapping("api/v1/movie/findById")
    public MovieDTO findById(@RequestParam int id) {
        MovieDTO movie = movieService.findById(id);
        return movie;
    }

    @PostMapping("api/v1/movie")
    public void createMovie(@RequestBody MovieCreateOrUpdateForm form){
        movieService.createOrUpdateMovie(form);
    }

    @PutMapping("api/v1/movie")
    public void updateMovie(@RequestBody MovieCreateOrUpdateForm form){
        movieService.createOrUpdateMovie(form);
    }

    @DeleteMapping("api/v1/movie")
    public void deleteById(@RequestParam int id){
        movieService.deleteById(id);
    }
}
