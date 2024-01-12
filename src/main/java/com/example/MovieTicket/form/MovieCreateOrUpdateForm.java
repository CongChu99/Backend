package com.example.MovieTicket.form;

import lombok.Data;

@Data
public class MovieCreateOrUpdateForm {
    private int id;
    private String title;
    private String content;
    private String genre;
    private String director;
    private String cast;
    private Data releaseDate;
    private int duaration;

}
