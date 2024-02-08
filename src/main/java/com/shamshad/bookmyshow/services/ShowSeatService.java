package com.shamshad.bookmyshow.services;

import com.shamshad.bookmyshow.exceptions.SeatNotAvailableException;
import com.shamshad.bookmyshow.models.Seat;
import com.shamshad.bookmyshow.models.Show;
import com.shamshad.bookmyshow.models.ShowSeat;
import com.shamshad.bookmyshow.models.ShowSeatStatus;
import com.shamshad.bookmyshow.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShowSeatService {
    private final ShowSeatRepository showSeatRepository;

    @Autowired
    public ShowSeatService(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
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
