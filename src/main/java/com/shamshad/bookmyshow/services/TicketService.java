package com.shamshad.bookmyshow.services;

import com.shamshad.bookmyshow.exceptions.InvalidArgumentsException;
import com.shamshad.bookmyshow.exceptions.SeatNotAvailableException;
import com.shamshad.bookmyshow.models.*;
import com.shamshad.bookmyshow.repositories.SeatRepository;
import com.shamshad.bookmyshow.repositories.ShowRepository;
import com.shamshad.bookmyshow.repositories.ShowSeatRepository;
import com.shamshad.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final ShowSeatRepository showSeatRepository;
    private final UserRepository userRepository;

    public TicketService(ShowRepository showRepository,
                         SeatRepository seatRepository,
                         ShowSeatRepository showSeatRepository,
                         UserRepository userRepository) {
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
    }


    public Ticket bookTicket(Long showId, Long userId, List<Long> seatIds) throws InvalidArgumentsException, SeatNotAvailableException {
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

        Ticket ticket = new Ticket();
        return ticket;
    }
}
