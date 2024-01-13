package com.example.MovieTicket.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="Cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;
    @Column(name= "cinemaName",nullable = false,length = 100)
    private String cinemaName;
    @Column(name="address",nullable = false,length = 100)
    private String address;
    @Column(name="phoneNumber",nullable = false)
    private int phoneNumber;
    @Column(name="city",nullable = false,length = 50)
    private String city;

//    @OneToMany(mappedBy = "Cinema")
//    private List<Schedule> schedules;
}
