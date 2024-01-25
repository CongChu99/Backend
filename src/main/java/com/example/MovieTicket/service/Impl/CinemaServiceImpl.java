package com.example.MovieTicket.service.Impl;

import com.example.MovieTicket.DTO.CinemaDTO;
import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.entity.Cinema;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.form.CinemaCreateOrUpdateForm;
import com.example.MovieTicket.repository.ICinemaRepository;
import com.example.MovieTicket.repository.IMovieRepository;
import com.example.MovieTicket.service.ICinemaService;
import com.example.MovieTicket.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class CinemaServiceImpl implements ICinemaService {

    @Autowired
    private ICinemaRepository cinemaRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Page<CinemaDTO> findAll(Pageable pageable) {
        Page<Cinema> pageCinema = cinemaRepository.findAll(pageable);
        // chuyen tu page movie -> page dto
        Page<CinemaDTO> pageDTO = pageCinema.map(new Function<Cinema, CinemaDTO>() {
            @Override
            public CinemaDTO apply(Cinema cinema) {
                return modelMapper.map(cinema, CinemaDTO.class);
            }
        });
        return pageDTO;
    }

    @Override
    public void createOrUpdate(CinemaCreateOrUpdateForm form) {
        if (form.getId() == 0) {
            // chuyen tu form -> entity
            Cinema cinema = modelMapper.map(form, Cinema.class);


            cinemaRepository.save(cinema);
        }else {
            Optional<Cinema> optional = cinemaRepository.findById(form.getId());
            if (!optional.isPresent())
                throw new RuntimeException("Id ko dung");

            Cinema cinema = optional.get();// 1  abc xyz a,   1 abc1 xyz null
            cinema.setCinemaName(form.getCinemaName());
            cinema.setPhoneNumber(form.getPhoneNumber());
            cinema.setAddress(form.getAddress());
            cinema.setCity(form.getCity());


            cinemaRepository.save(cinema);

        }
    }

    @Override
    public void deleteById(int id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public CinemaDTO findById(int id) {

        Optional<Cinema> optional = cinemaRepository.findById(id);
        if (!optional.isPresent())
            throw new RuntimeException("Id ko dung");

        Cinema cinema = optional.get();
        CinemaDTO cinemaDTO = modelMapper.map(cinema,CinemaDTO.class);
        return cinemaDTO;
    }
}
