package com.shamshad.bookmyshow.repositories;

import com.shamshad.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    // Get the list of Seats based on seat IDs
    List<Seat> findAllByIdIn(List<Long> seatIds);
}