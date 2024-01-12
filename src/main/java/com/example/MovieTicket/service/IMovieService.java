package com.example.MovieTicket.service;

import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.entity.Movie;

import java.util.List;

public interface IMovieService {


    List<Movie> findAll();

    void createOrUpdateMovie(Movie movie);

    void deleteById(int id);
}
