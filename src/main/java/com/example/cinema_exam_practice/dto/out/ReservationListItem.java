package com.example.cinema_exam_practice.dto.out;

import com.example.cinema_exam_practice.domain.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class ReservationListItem {
    private String userName;
    private String title;
    private Integer numberOfSeats;
    private String timeOfScreening;

    public ReservationListItem(Reservation reservation) {
        this.userName = reservation.getName();
        this.title = reservation.getScreening().getTitle();
        this.numberOfSeats = reservation.getScreening().getSeats();
        this.timeOfScreening = reservation.getScreening().getScreeningDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
