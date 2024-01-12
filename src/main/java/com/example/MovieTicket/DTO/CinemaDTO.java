package com.example.MovieTicket.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CinemaDTO {
    private int id;
    private String cinemaName;
    private String address;
    private String phoneNumber;
    private String city;
    private List<ScheduleDTO> scheduleDTOS;


}
