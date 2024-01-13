package com.example.MovieTicket.service;

import com.example.MovieTicket.entity.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAll();

    void createOrUpdateTicket(Ticket ticket);

    void deleteById(int id);
}
