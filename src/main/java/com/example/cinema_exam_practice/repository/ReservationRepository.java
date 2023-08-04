package com.example.cinema_exam_practice.repository;

import com.example.cinema_exam_practice.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
