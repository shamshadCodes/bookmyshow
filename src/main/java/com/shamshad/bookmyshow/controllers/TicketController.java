package com.shamshad.bookmyshow.controllers;

import com.shamshad.bookmyshow.dtos.MakePaymentRequestDTO;
import com.shamshad.bookmyshow.dtos.MakePaymentResponseDTO;
import com.shamshad.bookmyshow.exceptions.InvalidArgumentsException;
import com.shamshad.bookmyshow.exceptions.SeatNotAvailableException;
import com.shamshad.bookmyshow.models.Ticket;
import com.shamshad.bookmyshow.services.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/")
    public MakePaymentResponseDTO bookTicket(MakePaymentRequestDTO requestDTO) {
        MakePaymentResponseDTO responseDTO = new MakePaymentResponseDTO();

        //TODO: Add a controllerAdvice class to handle exceptions
        try{
            Ticket ticket = ticketService.bookTicket
                    (requestDTO.getShowId(), requestDTO.getUserId(), requestDTO.getSeats());
        }catch (InvalidArgumentsException | SeatNotAvailableException e){
            System.out.println(e.getMessage());
        }

        return responseDTO;
    }
}
