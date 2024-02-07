package com.shamshad.bookmyshow.services;

import com.shamshad.bookmyshow.exceptions.InvalidArgumentsException;
import com.shamshad.bookmyshow.exceptions.SeatNotAvailableException;
import com.shamshad.bookmyshow.models.*;
import com.shamshad.bookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeoutException;

@Service
public class TicketService {

    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final ShowSeatRepository showSeatRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(ShowRepository showRepository,
                         SeatRepository seatRepository,
                         ShowSeatRepository showSeatRepository,
                         UserRepository userRepository,
                         TicketRepository ticketRepository) {
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }


    public Ticket bookTicket(Long showId, Long userId, List<Long> seatIds) throws TimeoutException, InvalidArgumentsException, SeatNotAvailableException {
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new InvalidArgumentsException("Show Id: " + showId + " doesn't exist.");
        }

        Show show = optionalShow.get();

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new InvalidArgumentsException("User with ID: " + userId + " doesn't exist");
        }

        User user = optionalUser.get();

        List<Seat> seats = seatRepository.findAllByIdIn(seatIds);

        // TODO: Ensure that showSeats are created when a new show is added to the DB
        List<ShowSeat> savedShowSeats = reserveShowSeats(seats, show);

        Ticket ticket = new Ticket();
        ticket.setBookedBy(user);
        ticket.setTicketStatus(TicketStatus.PROCESSING);
        ticket.setShow(show);
        ticket.setShowSeats(savedShowSeats);
        ticket.setBookingTime(new Date());
//        ticket.setTicketPrice();

        Ticket savedTicket = ticketRepository.save(ticket);
        return savedTicket;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 5) // To avoid race conditions
    public List<ShowSeat> reserveShowSeats(List<Seat> seats, Show show) throws SeatNotAvailableException {
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats, show);

        // Creating an Instant threshold that is 15 minutes from the current time
        Instant thresholdInstant = Instant.now().minus(Duration.ofMinutes(15));

        for(ShowSeat showSeat: showSeats){
            if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)
                    || (
                            showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED)
                                    && thresholdInstant.isBefore(showSeat.getSeatLockedAt().toInstant())
                        )
                )
            ) throw new SeatNotAvailableException("The selected seat(s) are not available. Please try again!");
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();

        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setSeatLockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        return savedShowSeats;
    }
}
