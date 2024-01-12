package com.example.MovieTicket.service.Impl;

import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.repository.IMovieRepository;
import com.example.MovieTicket.service.ICinemaService;
import com.example.MovieTicket.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements ICinemaService {

    @Autowired
    private ICinemaService cinemaService;


}
