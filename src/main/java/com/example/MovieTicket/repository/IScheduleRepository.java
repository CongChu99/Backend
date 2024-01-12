package com.example.MovieTicket.repository;

import com.example.MovieTicket.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule,Integer> {
}
