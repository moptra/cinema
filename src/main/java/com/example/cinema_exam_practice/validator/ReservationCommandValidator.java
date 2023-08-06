package com.example.cinema_exam_practice.validator;

import com.example.cinema_exam_practice.domain.Reservation;
import com.example.cinema_exam_practice.domain.Screening;
import com.example.cinema_exam_practice.dto.in.ReservationCommand;
import com.example.cinema_exam_practice.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class ReservationCommandValidator implements Validator {

    private final ScreeningRepository screeningRepository;

    @Autowired
    public ReservationCommandValidator(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ReservationCommand.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if (object != null) {

            ReservationCommand reservationCommand = (ReservationCommand) object;

            String title = reservationCommand.getScreeningTitle();
            String formattedReservationDate = reservationCommand.getScreeningDate()
                    .replaceAll("[^0-9]", "");

            List<Screening> screenings = screeningRepository.getScreeningsByTitle(title);

            Screening searchedScreening = null;

            for (Screening screening : screenings) {
                if (formattedReservationDate.equals(screening.getScreeningDate()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).replaceAll("[^0-9]", ""))) {
                    searchedScreening = screening;
                }
            }

            int totalSeats = searchedScreening.getSeats();

            List<Reservation> reservationList = searchedScreening.getReservations();

            int reservedSeats = 0;

            for (Reservation reservation : reservationList) {
                reservedSeats += reservation.getReservedSeats();
            }

            int freeSeats = totalSeats - reservedSeats;
            if (reservationCommand.getReservedSeats() > freeSeats) {
                errors.rejectValue("reservedSeats", "reservedSeats.tooMuch");
            }
        }
    }
}
