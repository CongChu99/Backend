package com.example.MovieTicket.controller;

import com.example.MovieTicket.DTO.CinemaDTO;
import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.entity.Cinema;
import com.example.MovieTicket.form.CinemaCreateOrUpdateForm;
import com.example.MovieTicket.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CinemaController {
    @Autowired
    private ICinemaService cinemaService;

    @GetMapping("api/v1/cinema")
    public Page<CinemaDTO> findAll(Pageable pageable){
        Page<CinemaDTO> cinema = cinemaService.findAll(pageable);
        return cinema;

    }

    @PostMapping("api/v1/cinema")
    public void createCinema (@RequestBody CinemaCreateOrUpdateForm form){
        cinemaService.createOrUpdate(form);
    }

    @PutMapping("api/v1/cinema")
    public void updateCinema(@RequestBody CinemaCreateOrUpdateForm form){
        cinemaService.createOrUpdate(form);
    }

    @DeleteMapping("api/v1/cinema")
    public void deleteById(@RequestParam int id){
        cinemaService.deleteById(id);

    }

}
