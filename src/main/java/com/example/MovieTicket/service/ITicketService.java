package com.example.MovieTicket.service;

import com.example.MovieTicket.DTO.TicketDTO;
import com.example.MovieTicket.entity.Ticket;
import com.example.MovieTicket.form.TicketCreateOrUpdateForm;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAll();

    void createOrUpdateTicket(TicketCreateOrUpdateForm form);

    void deleteById(int id);

    TicketDTO findById(int id);
}
