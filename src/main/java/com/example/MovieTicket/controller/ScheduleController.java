package com.example.MovieTicket.controller;

import com.example.MovieTicket.DTO.ScheduleDTO;
import com.example.MovieTicket.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    private IScheduleService scheduleService;

    @GetMapping("api/v1/schedule")
    public Page<ScheduleDTO> findAll(Pageable pageable, @RequestParam String search){
        Page<ScheduleDTO> scheduleDTOS = scheduleService.findAll(pageable,search);
        return scheduleDTOS;
    }

}
