package com.example.cinema_exam_practice.service;

import com.example.cinema_exam_practice.domain.Reservation;
import com.example.cinema_exam_practice.domain.Screening;
import com.example.cinema_exam_practice.dto.in.ScreeningCommand;
import com.example.cinema_exam_practice.dto.out.MovieSummaryListItem;
import com.example.cinema_exam_practice.dto.out.ScreeningListItem;
import com.example.cinema_exam_practice.repository.ScreeningRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ScreeningService {
    private ScreeningRepository screeningRepository;


    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public void addScreening(ScreeningCommand screeningCommand) {
        Screening screening = new Screening(screeningCommand);
        screeningRepository.save(screening);
    }

    public List<ScreeningListItem> getAllScreening() {
        List<Screening> screeningList = screeningRepository.getAllScreeningByDateAscOrder();
        return screeningList.stream()
                .map(ScreeningListItem::new)
                .collect(Collectors.toList());
    }

    public List<Screening> getScreenings() {
        return screeningRepository.findAll();
    }

    public List<MovieSummaryListItem> getScreeningSummary() {
        List<Screening> screenings = this.getScreenings();
        List<String> movieTitles = new ArrayList<>();

        Integer numberOfScreenings = 0;
        Integer screeningTotalSoldTickets = 0;

        List<MovieSummaryListItem> movieSummaryListItemList = new ArrayList<>();

        for (Screening screening : screenings) {
            if (!movieTitles.contains(screening.getTitle())) {
                movieTitles.add(screening.getTitle());
            }
        }

        for (String title : movieTitles) {
            for (Screening screening : screenings) {
                if (title.equals(screening.getTitle())) {
                    numberOfScreenings++;
                    for (Reservation reservation : screening.getReservations()) {
                        screeningTotalSoldTickets += reservation.getReservedSeats();
                    }

                }
            }
            MovieSummaryListItem movieSummaryListItem =
                    new MovieSummaryListItem(numberOfScreenings, screeningTotalSoldTickets,title);
            movieSummaryListItemList.add(movieSummaryListItem);

            numberOfScreenings = 0;
            screeningTotalSoldTickets = 0;
        }
        return movieSummaryListItemList;
    }
}
