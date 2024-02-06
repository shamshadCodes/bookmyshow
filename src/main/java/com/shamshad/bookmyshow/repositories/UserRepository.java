package com.shamshad.bookmyshow.repositories;

import com.shamshad.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Search for a user by userId
    Optional<User> findById(Long userId);
}