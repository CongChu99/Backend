package com.example.MovieTicket.controller;

import com.example.MovieTicket.DTO.ScheduleDTO;
import com.example.MovieTicket.entity.Schedule;
import com.example.MovieTicket.form.ScheduleCreateOrUpdateForm;
import com.example.MovieTicket.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleController {

    @Autowired
    private IScheduleService scheduleService;

    @GetMapping("api/v1/schedule")
    public Page<ScheduleDTO> findAll(Pageable pageable){
        Page<ScheduleDTO> scheduleDTOS = scheduleService.findAll(pageable);
        return scheduleDTOS;
    }

    @GetMapping("api/v1/schedule/findById")
    public ScheduleDTO findAll(@RequestParam int id){
        ScheduleDTO scheduleDTOS = scheduleService.findById(id);
        return scheduleDTOS;
    }

    @PostMapping("api/v1/schedule")
    public void createSchedule(@RequestBody ScheduleCreateOrUpdateForm form){
        scheduleService.createOrUpdate(form);
    }

    @PutMapping("api/v1/schedule")
    public void updateSchedule(@RequestBody ScheduleCreateOrUpdateForm form){
        scheduleService.createOrUpdate(form);
    }

    @DeleteMapping("api/v1/schedule")
    private void deleteById(@RequestParam int id){
        scheduleService.deleteById(id);
    }

}
