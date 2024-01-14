package com.example.MovieTicket.DTO;

import lombok.Data;

@Data
public class ScheduleDTO {
    private int id;
    private String showtime;
    private String title;
    private String cinemaName;
}
