package com.example.MovieTicket.service;

import com.example.MovieTicket.DTO.CinemaDTO;
import com.example.MovieTicket.entity.Cinema;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.form.CinemaCreateOrUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICinemaService {

   Page<CinemaDTO> findAll(Pageable pageable);

    void createOrUpdate(CinemaCreateOrUpdateForm form);

    void deleteById(int id);

    CinemaDTO findById(int id);
}
