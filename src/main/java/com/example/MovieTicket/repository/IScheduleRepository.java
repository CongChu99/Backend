package com.example.MovieTicket.repository;

import com.example.MovieTicket.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule,Integer> {

    List<Schedule> findByMovieId(int id);
}
