package com.example.cinema_exam_practice.dto.out;

import com.example.cinema_exam_practice.domain.Reservation;
import com.example.cinema_exam_practice.domain.Screening;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ScreeningListItem {

    private String title;
    private LocalDateTime screeningDate;
    private Integer totalSeats;
    private Integer freeSeats;
    private String imageUrl;

    public ScreeningListItem(Screening screening) {
        this.title = screening.getTitle();
        this.screeningDate = screening.getScreeningDate();
        this.totalSeats = screening.getSeats();

        Integer numberOfReservedSeats = 0;
        List<Reservation> reservations = screening.getReservations();
        for (Reservation reservation : reservations) {
            numberOfReservedSeats += reservation.getReservedSeats();
        }

        this.freeSeats = screening.getSeats() - numberOfReservedSeats;
        this.imageUrl = screening.getImageUrl();
    }
}
