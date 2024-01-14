package com.example.MovieTicket.controller;

import com.example.MovieTicket.entity.Cinema;
import com.example.MovieTicket.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CinemaController {
    @Autowired
    private ICinemaService cinemaService;

    @GetMapping("api/v1/cinema")
    public List<Cinema> findAll(){
        return cinemaService.findAll();
    }

    @PostMapping("api/v1/cinema")
    public void createCinema (@RequestBody Cinema cinema){
        cinemaService.createOrUpdate(cinema);
    }

    @PutMapping("api/v1/cinema")
    public void updateCinema(@RequestBody Cinema cinema){
        cinemaService.createOrUpdate(cinema);
    }

    @DeleteMapping("api/v1/cinema")
    public void deleteById(@RequestParam int id){
        cinemaService.deleteById(id);

    }

}
