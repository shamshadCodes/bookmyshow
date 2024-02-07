package com.shamshad.bookmyshow.mappers;

import com.shamshad.bookmyshow.dtos.BookTicketResponseDTO;
import com.shamshad.bookmyshow.models.ShowSeat;
import com.shamshad.bookmyshow.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketMapper {
    public static BookTicketResponseDTO ticketToBookTicketResponseDTO(Ticket ticket){
        BookTicketResponseDTO responseDTO  = new BookTicketResponseDTO();
        responseDTO.setTicketPrice(ticket.getTicketPrice());
        responseDTO.setTheatreName(ticket.getShow().getAuditorium().getTheatre().getName());
        responseDTO.setAuditoriumName(ticket.getShow().getAuditorium().getName());
        responseDTO.setShowStartTime(ticket.getShow().getStartTime());

        List<String> seats = new ArrayList<>();
        for(ShowSeat showSeat: ticket.getShowSeats()){
            seats.add(showSeat.getSeat().getName());
        }
        responseDTO.setSeats(seats);

        return responseDTO;
    }

}
