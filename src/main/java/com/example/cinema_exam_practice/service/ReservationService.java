package com.example.cinema_exam_practice.service;

import com.example.cinema_exam_practice.domain.Reservation;
import com.example.cinema_exam_practice.domain.Screening;
import com.example.cinema_exam_practice.dto.in.ReservationCommand;
import com.example.cinema_exam_practice.dto.out.ReservationListItem;
import com.example.cinema_exam_practice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservationService {
    private ReservationRepository reservationRepository;
    private ScreeningService screeningService;

    @Autowired
    public ReservationService(@Lazy ReservationRepository reservationRepository, ScreeningService screeningService) {
        this.reservationRepository = reservationRepository;
        this.screeningService = screeningService;
    }

    public void addReservation(ReservationCommand reservationCommand) {
        String screeningTitle = reservationCommand.getScreeningTitle();
        String screeningDate = reservationCommand.getScreeningDate();
        List<Screening> screenings = screeningService.getScreenings();

        for (Screening screening : screenings) {
            String formattedScreeningDate = screening.getScreeningDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).replaceAll("[^0-9]", "");
            String formattedReservationDate = screeningDate.replaceAll("[^0-9]", "");

            if (screening.getTitle().equals((screeningTitle))
                    && formattedScreeningDate.equals(formattedReservationDate)) {
                Reservation reservation = new Reservation(reservationCommand, screening);
                reservationRepository.save(reservation);
            }
        }
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<ReservationListItem> getAllReservationsInReservationListItems() {
        List<Reservation> reservationList = this.getAllReservations();
        return reservationList.stream()
                .map(ReservationListItem::new)
                .collect(Collectors.toList());
    }
}
