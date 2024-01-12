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
    public List<MovieDTO> findAll() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> movieDTOS = new ArrayList<>();
        for (Movie movie : movies){
            MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);


        }

        return ;
    }
}
