package com.example.MovieTicket.service;

import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.form.MovieCreateOrUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMovieService {


    Page<MovieDTO> findAll(Pageable pageable);

    void createOrUpdateMovie(MovieCreateOrUpdateForm form);

    void deleteById(int id);

    MovieDTO findById(int id);
}
