package com.example.cinema_exam_practice.controller;

import com.example.cinema_exam_practice.dto.in.ReservationCommand;
import com.example.cinema_exam_practice.dto.out.ReservationListItem;
import com.example.cinema_exam_practice.dto.out.ScreeningListItem;
import com.example.cinema_exam_practice.service.ReservationService;
import com.example.cinema_exam_practice.validator.ReservationCommandValidator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private ReservationService reservationService;

    private ReservationCommandValidator reservationCommandValidator;

    public ReservationController(ReservationService reservationService, ReservationCommandValidator reservationCommandValidator) {
        this.reservationService = reservationService;
        this.reservationCommandValidator = reservationCommandValidator;
    }

    @InitBinder("reservationCommand")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(reservationCommandValidator);
    }

    @PostMapping
    public ResponseEntity addReservation(@RequestBody @Valid ReservationCommand reservationCommand) {
        reservationService.addReservation(reservationCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReservationListItem>> getAllReservations() {
        List<ReservationListItem> reservationListItemList = reservationService.getAllReservationsInReservationListItems();
        return new ResponseEntity<>(reservationListItemList, HttpStatus.OK);
    }
}
