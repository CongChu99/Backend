package com.example.MovieTicket.form;

import com.example.MovieTicket.entity.Schedule;
import lombok.Data;

@Data
public class TicketCreateOrUpdateForm {
    private int id;
    private String seatNumber;
    private String status;
    private String price;
    private int scheduleId;
}
