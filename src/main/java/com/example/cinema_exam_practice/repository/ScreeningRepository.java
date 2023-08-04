package com.example.cinema_exam_practice.repository;

import com.example.cinema_exam_practice.domain.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}
