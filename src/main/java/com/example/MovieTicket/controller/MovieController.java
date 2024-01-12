package com.example.MovieTicket.controller;

import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MovieController {

    @Autowired
    private IMovieService movieService;

    // get all movie
    @GetMapping("api/v1/movie")
    public List<MovieDTO> findAll() {
        List<MovieDTO> movieDTOS = movieService.findAll();
        return movieDTOS;

    }
}
