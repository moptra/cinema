package com.example.cinema_exam_practice.repository;

import com.example.cinema_exam_practice.domain.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {

    @Query("SELECT s FROM Screening s ORDER BY s.screeningDate asc")
    List<Screening> getAllScreeningByDateAscOrder();
}
