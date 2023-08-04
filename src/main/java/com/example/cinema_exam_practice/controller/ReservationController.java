package com.example.cinema_exam_practice.controller;

import com.example.cinema_exam_practice.dto.in.ReservationCommand;
import com.example.cinema_exam_practice.dto.in.ScreeningCommand;
import com.example.cinema_exam_practice.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Void> addReservation(@RequestBody ReservationCommand reservationCommand) {
        reservationService.addReservation(reservationCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
