package com.example.MovieTicket.controller;


import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.entity.Ticket;
import com.example.MovieTicket.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class TicketController {

    @Autowired
    private ITicketService ticketService;

    @GetMapping("api/v1/ticket")
    public List<Ticket> findAll() {
        List<Ticket> tickets = ticketService.findAll();
        return tickets;
    }
    @PostMapping("api/v1/ticket")
    public void createTicket(@RequestBody Ticket ticket){
        ticketService.createOrUpdateTicket(ticket);
    }

    @PutMapping("api/v1/ticket")
    public void updateTicket(@RequestBody Ticket ticket){
        ticketService.createOrUpdateTicket(ticket);
    }

    @DeleteMapping("api/v1/ticket")
    public void deleteById(@RequestParam int id){
        ticketService.deleteById(id);
    }
}
