package com.example.MovieTicket.controller;


import com.example.MovieTicket.DTO.TicketDTO;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.entity.Ticket;
import com.example.MovieTicket.form.TicketCreateOrUpdateForm;
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

    @GetMapping("api/v1/ticket/findById")
    public TicketDTO findById(int id){
        return ticketService.findById(id);
    }

    @PostMapping("api/v1/ticket")
    public void createTicket(@RequestBody TicketCreateOrUpdateForm form){
        ticketService.createOrUpdateTicket(form);
    }

    @PutMapping("api/v1/ticket")
    public void updateTicket(@RequestBody TicketCreateOrUpdateForm form){
        ticketService.createOrUpdateTicket(form);
    }

    @DeleteMapping("api/v1/ticket")
    public void deleteById(@RequestParam int id){
        ticketService.deleteById(id);
    }
}
