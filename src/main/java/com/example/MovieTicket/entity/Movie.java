package com.example.MovieTicket.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title",nullable = false,length = 100)
    private String title;

    @Column(name="content",nullable = false,length = 200)
    private String content;

    @Column(name="genre",length = 50)
    private String genre;

    @Column(name="director",nullable = false,length = 50)
    private String director;

    @Column(name="cast",nullable = false,length = 50)
    private String cast;

    @Column(name="releaseDate",nullable = false)
    private String releaseDate;

    @Column(name="duaration",nullable = false)
    private int duaration ;

//    @OneToMany(mappedBy = "Movie")
//    private List<Schedule> schedules;

}
