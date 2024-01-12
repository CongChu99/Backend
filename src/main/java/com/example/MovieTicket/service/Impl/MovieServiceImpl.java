package com.example.MovieTicket.service.Impl;

import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.repository.IMovieRepository;
import com.example.MovieTicket.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public void createOrUpdateMovie(Movie movie) {
        movieRepository.save(movie);

    }

    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);

    }
}
