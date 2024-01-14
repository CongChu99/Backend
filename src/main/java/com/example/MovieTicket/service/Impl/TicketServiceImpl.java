package com.example.MovieTicket.service.Impl;

import com.example.MovieTicket.entity.Ticket;
import com.example.MovieTicket.repository.ITicketRepository;
import com.example.MovieTicket.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public void createOrUpdateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void deleteById(int id) {
        ticketRepository.deleteById(id);
    }
}
