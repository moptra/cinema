package com.example.cinema_exam_practice.controller;

import com.example.cinema_exam_practice.dto.in.ScreeningCommand;
import com.example.cinema_exam_practice.dto.out.MovieSummaryListItem;
import com.example.cinema_exam_practice.dto.out.ScreeningListItem;
import com.example.cinema_exam_practice.service.ScreeningService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {
    private ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @PostMapping
    public ResponseEntity<Void> addScreening(@RequestBody ScreeningCommand screeningCommand) {
        screeningService.addScreening(screeningCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScreeningListItem>> getAllScreening() {
        List<ScreeningListItem> screeningListItemList = screeningService.getAllScreening();
        return new ResponseEntity<>(screeningListItemList, HttpStatus.OK);
    }

    @GetMapping("/summary")
    public ResponseEntity<List<MovieSummaryListItem>> getScreeningSummary() {
        List<MovieSummaryListItem> movieSummaryListItemList = screeningService.getScreeningSummary();
        return new ResponseEntity<>(movieSummaryListItemList, HttpStatus.OK);
    }

}
