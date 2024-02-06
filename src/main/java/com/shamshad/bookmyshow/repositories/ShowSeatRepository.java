package com.shamshad.bookmyshow.repositories;

import com.shamshad.bookmyshow.models.Seat;
import com.shamshad.bookmyshow.models.Show;
import com.shamshad.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllBySeatInAndShow(List<Seat> seats, Show show);
}