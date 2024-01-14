package com.example.MovieTicket.form;

import com.example.MovieTicket.entity.Cinema;
import lombok.Data;

@Data
public class ScheduleCreateOrUpdateForm {
    private int id;
    private String showtime;
    private int movieId;
    private int cinemaId;
}
