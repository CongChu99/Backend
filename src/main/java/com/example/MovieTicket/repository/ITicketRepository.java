package com.example.MovieTicket.repository;

import com.example.MovieTicket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket,Integer> {
}
