package com.example.MovieTicket.DTO;

import lombok.Data;

import java.util.List;

@Data
public class MovieDTO {
    private int id;
    private String title;
    private String content;
    private String genre;
    private String director;
    private String cast;
    private String releaseDate;
    private int duaration;
    private List<ScheduleDTO> scheduleDTOS;

}
