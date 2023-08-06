package com.example.cinema_exam_practice.repository;

import com.example.cinema_exam_practice.domain.Reservation;
import com.example.cinema_exam_practice.domain.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {

    @Query("SELECT s FROM Screening s ORDER BY s.screeningDate asc")
    List<Screening> getAllScreeningByDateAscOrder();

    @Query("SELECT s from Screening s WHERE s.title =:title")
    Screening getScreeningByTitle(@Param("title") String title);


}
