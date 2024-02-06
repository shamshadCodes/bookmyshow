package com.shamshad.bookmyshow.repositories;

import com.shamshad.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {

    //Find a show by showId
    Optional<Show> findById(Long showId);
}