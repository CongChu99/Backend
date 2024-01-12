package com.example.MovieTicket.repository;

import com.example.MovieTicket.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Integer> {
}
