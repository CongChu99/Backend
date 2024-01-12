package com.example.MovieTicket.service;

import com.example.MovieTicket.entity.Cinema;
import com.example.MovieTicket.entity.Movie;

import java.util.List;

public interface ICinemaService {

    List<Cinema> findAll();

    void createOrUpdate(Cinema cinema);

    void deleteById(int id);
}
