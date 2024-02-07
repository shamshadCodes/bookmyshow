package com.shamshad.bookmyshow.controllers;

import com.shamshad.bookmyshow.dtos.BookTicketRequestDTO;
import com.shamshad.bookmyshow.dtos.BookTicketResponseDTO;
import com.shamshad.bookmyshow.exceptions.InvalidArgumentsException;
import com.shamshad.bookmyshow.exceptions.SeatNotAvailableException;
import com.shamshad.bookmyshow.models.Ticket;
import com.shamshad.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeoutException;

import static com.shamshad.bookmyshow.mappers.TicketMapper.ticketToBookTicketResponseDTO;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/")
    public BookTicketResponseDTO bookTicket(@RequestBody BookTicketRequestDTO requestDTO) {
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();

        //TODO: Add a controllerAdvice class to handle exceptions
        try{
            Ticket ticket = new Ticket();
            ticket = ticketService.bookTicket
                    (requestDTO.getShowId(), requestDTO.getUserId(), requestDTO.getSeats());

            responseDTO = ticketToBookTicketResponseDTO(ticket);
            responseDTO.setStatus("SUCCESS");

        } catch (InvalidArgumentsException | SeatNotAvailableException e){
            responseDTO.setMessage(e.getMessage());
            responseDTO.setStatus("FAILURE");
        } catch (TimeoutException e){
            responseDTO.setMessage("Something went wrong. Please try again!");
            responseDTO.setStatus("FAILURE");
        }

        return responseDTO;
    }
}
