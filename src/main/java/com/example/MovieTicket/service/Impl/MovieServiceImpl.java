package com.example.MovieTicket.service.Impl;

import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.DTO.ScheduleDTO;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.entity.Schedule;
import com.example.MovieTicket.form.MovieCreateOrUpdateForm;
import com.example.MovieTicket.repository.IMovieRepository;
import com.example.MovieTicket.repository.IScheduleRepository;
import com.example.MovieTicket.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IScheduleRepository scheduleRepository;


    @Override
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> pageMovie = movieRepository.findAll(pageable);
        // chuyen tu page movie -> page dto
        Page<MovieDTO> pageDTO = pageMovie.map(new Function<Movie, MovieDTO>() {
            @Override
            public MovieDTO apply(Movie movie) {
                return modelMapper.map(movie, MovieDTO.class);
            }
        });
        return pageDTO;
    }

    @Override
    public void createOrUpdateMovie(MovieCreateOrUpdateForm form) {
        if (form.getId() == 0) {
            // chuyen tu form -> entity
            Movie movie = modelMapper.map(form, Movie.class);
            movieRepository.save(movie);

        }else {
            Optional<Movie> optional = movieRepository.findById(form.getId());
            if (!optional.isPresent())
                throw new RuntimeException("Id ko dung");

            Movie movie = optional.get();// 1  abc xyz a,   1 abc1 xyz null
            movie.setCast(form.getCast());
            movie.setDirector(form.getDirector());
            movie.setGenre(form.getGenre());
            movie.setContent(form.getContent());
            movie.setDuaration(form.getDuaration());
            movie.setReleaseDate(form.getReleaseDate());
            movie.setTitle(form.getTitle());

            movieRepository.save(movie);

        }

    }

    @Override
    public void deleteById(int id) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (!optional.isPresent())
            throw new RuntimeException("Id ko dung");

        movieRepository.deleteById(id);

    }

    @Override
    public MovieDTO findById(int id) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (!optional.isPresent())
            throw new RuntimeException("Id ko dung");

        Movie movie = optional.get();
        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);

        // ds lịch chieu theo id phim
        List<Schedule> schedules = scheduleRepository.findByMovieId(id);
        List<ScheduleDTO> scheduleDTOS = modelMapper.map(schedules, new TypeToken<List<ScheduleDTO>>(){}.getType());
        movieDTO.setScheduleDTOS(scheduleDTOS);

        return movieDTO;
    }
}
