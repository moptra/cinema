package com.example.cinema_exam_practice.dto.out;

import com.example.cinema_exam_practice.domain.Screening;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
        this.freeSeats = screening.getSeats() - (int)screening.getReservations().stream()
                .map(r -> r.getReservedSeats()).count();
        this.imageUrl = screening.getImageUrl();
    }
}
