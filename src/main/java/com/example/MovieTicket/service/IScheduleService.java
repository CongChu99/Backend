package com.example.MovieTicket.service;

import com.example.MovieTicket.DTO.ScheduleDTO;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IScheduleService {

    Page<ScheduleDTO> findAll(Pageable pageable, String search);

    void createOrUpdate(Schedule schedule);
}
