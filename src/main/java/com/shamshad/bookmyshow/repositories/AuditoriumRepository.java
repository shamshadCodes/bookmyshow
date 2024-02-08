package com.shamshad.bookmyshow.repositories;

import com.shamshad.bookmyshow.models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}