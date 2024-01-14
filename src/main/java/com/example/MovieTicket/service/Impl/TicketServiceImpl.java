package com.example.MovieTicket.service.Impl;

import com.example.MovieTicket.DTO.MovieDTO;
import com.example.MovieTicket.DTO.ScheduleDTO;
import com.example.MovieTicket.DTO.TicketDTO;
import com.example.MovieTicket.entity.Movie;
import com.example.MovieTicket.entity.Schedule;
import com.example.MovieTicket.entity.Ticket;
import com.example.MovieTicket.form.TicketCreateOrUpdateForm;
import com.example.MovieTicket.repository.IScheduleRepository;
import com.example.MovieTicket.repository.ITicketRepository;
import com.example.MovieTicket.service.ITicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IScheduleRepository scheduleRepository;
    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }



    @Override
    public void createOrUpdateTicket(TicketCreateOrUpdateForm form) {
        if (form.getId() == 0) {
            // chuyen tu form -> entity
            Ticket ticket = modelMapper.map(form, Ticket.class);

            // tu scheduId tim ra Schedu
            Optional<Schedule> optional = scheduleRepository.findById(form.getScheduleId());

            if (!optional.isPresent())
                throw new RuntimeException("Id schedu ko dung");

            // set schedu vao ticket
            ticket.setSchedule(optional.get());
            ticketRepository.save(ticket);
        }else {

            Optional<Ticket> optionalTicket = ticketRepository.findById(form.getId());
            if (!optionalTicket.isPresent())
                throw new RuntimeException("Id ko dung");
            Ticket ticket = optionalTicket.get();
            //set may thuoc tinsh id,,,,
            ticket.setId(form.getId());
            ticket.setPrice(form.getPrice());
            ticket.setSeatNumber(form.getSeatNumber());
            ticket.setStatus(form.getStatus());

            // tu scheduId tim ra Schedu
            Optional<Schedule> optional = scheduleRepository.findById(form.getScheduleId());

            if (!optional.isPresent())
                throw new RuntimeException("Id schedu ko dung");

            // set schedu vao ticket
            ticket.setSchedule(optional.get());
            ticketRepository.save(ticket);

        }

    }

    @Override
    public void deleteById(int id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public TicketDTO findById(int id) {
        Optional<Ticket> optional = ticketRepository.findById(id);
        if (!optional.isPresent())
            throw new RuntimeException("Id ko dung");

        Ticket ticket = optional.get();
        TicketDTO ticketDTO = modelMapper.map(ticket, TicketDTO.class);//
        // lay schedu tu ticket
        Schedule schedule = ticket.getSchedule();
        // chueyn thanh dto
        ScheduleDTO  scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);
        ticketDTO.setScheduleDTO(scheduleDTO);

        return ticketDTO;
    }
}
