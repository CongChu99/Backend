package com.example.MovieTicket.DTO;

import com.example.MovieTicket.entity.Schedule;
import lombok.Data;

@Data
public class TicketDTO {
    private int id;
    private String seatNumber;
    private String status;
    private String price;
    private ScheduleDTO scheduleDTO;
}
