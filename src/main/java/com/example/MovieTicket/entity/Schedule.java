package com.example.MovieTicket.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="showtime",nullable = false,length = 30)
    private String showtime;

    @ManyToOne
    @JoinColumn(name="Movie_id",nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="Cinema_id",nullable = false)
    private Cinema cinema;
}
