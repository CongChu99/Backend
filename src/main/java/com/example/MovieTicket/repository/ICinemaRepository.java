package com.example.MovieTicket.repository;

import com.example.MovieTicket.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICinemaRepository extends JpaRepository<Cinema,Integer> {
}
