package com.example.MovieTicket.service.Impl;

import com.example.MovieTicket.DTO.ScheduleDTO;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.entity.Schedule;
import com.example.MovieTicket.repository.IMovieRepository;
import com.example.MovieTicket.repository.IScheduleRepository;
import com.example.MovieTicket.service.IMovieService;
import com.example.MovieTicket.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Autowired
    private IScheduleRepository scheduleRepository;

    @Override
    public Page<ScheduleDTO> findAll(Pageable pageable, String search) {
        return null;
    }

    @Override
    public void createOrUpdate(Schedule schedule) {
        scheduleRepository.save(schedule);
    }
}
