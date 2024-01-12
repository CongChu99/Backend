package com.example.MovieTicket.form;

import lombok.Data;

@Data
public class CinemaCreateOrUpdateForm {
    private int id;
    private String cinemaName;
    private String address;
    private int phoneNumber;
    private String city;
}
