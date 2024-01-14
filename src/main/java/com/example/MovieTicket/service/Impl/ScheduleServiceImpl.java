package com.example.MovieTicket.service.Impl;

import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.DTO.ScheduleDTO;
import com.example.MovieTicket.entity.Cinema;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.entity.Schedule;
import com.example.MovieTicket.form.ScheduleCreateOrUpdateForm;
import com.example.MovieTicket.repository.ICinemaRepository;
import com.example.MovieTicket.repository.IMovieRepository;
import com.example.MovieTicket.repository.IScheduleRepository;
import com.example.MovieTicket.service.IMovieService;
import com.example.MovieTicket.service.IScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Autowired
    private IScheduleRepository scheduleRepository;

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private ICinemaRepository cinemaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<ScheduleDTO> findAll(Pageable pageable) {
        Page<Schedule> pageSchedule = scheduleRepository.findAll(pageable);
        // chuyen tu page movie -> page dto
        Page<ScheduleDTO> pageDTO = pageSchedule.map(new Function<Schedule, ScheduleDTO>() {
            @Override
            public ScheduleDTO apply(Schedule schedule) {
                return modelMapper.map(schedule, ScheduleDTO.class);
            }
        });
        return pageDTO;
    }

    @Override
    public void createOrUpdate(ScheduleCreateOrUpdateForm form) {

        if (form.getId() == 0) {
            // chuyen tu form -> entity
            Schedule schedule = modelMapper.map(form, Schedule.class);
            //tim movie theo id phim
            Optional<Movie> movieOptional= movieRepository.findById(form.getMovieId());
            if (!movieOptional.isPresent())
                throw new RuntimeException("Id phim ko dung");

            schedule.setMovie(movieOptional.get());
            //tim rap theo id rap
            Optional<Cinema> cinameOptional= cinemaRepository.findById(form.getCinemaId());
            if (!cinameOptional.isPresent())
                throw new RuntimeException("Id rap ko dung");

            schedule.setCinema(cinameOptional.get());

            scheduleRepository.save(schedule);
        }else {
            Optional<Schedule> optional = scheduleRepository.findById(form.getId());
            if (!optional.isPresent())
                throw new RuntimeException("Id ko dung");

            Schedule schedule = optional.get();// 1  abc xyz a,   1 abc1 xyz null
            schedule.setShowtime(form.getShowtime());
            //tim movie theo id phim
            Optional<Movie> movieOptional= movieRepository.findById(form.getMovieId());
            if (!movieOptional.isPresent())
                throw new RuntimeException("Id phim ko dung");

            schedule.setMovie(movieOptional.get());
            //tim rap theo id rap
            Optional<Cinema> cinameOptional= cinemaRepository.findById(form.getCinemaId());
            if (!cinameOptional.isPresent())
                throw new RuntimeException("Id rap ko dung");

            schedule.setCinema(cinameOptional.get());

            scheduleRepository.save(schedule);

        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public ScheduleDTO findById(int id) {
        Optional<Schedule> optional = scheduleRepository.findById(id);
        if (!optional.isPresent())
            throw new RuntimeException("Id ko dung");

        Schedule schedule = optional.get();
        ScheduleDTO scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);
        return scheduleDTO;
    }
}
