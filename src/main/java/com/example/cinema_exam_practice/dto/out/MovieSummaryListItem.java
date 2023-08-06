package com.example.cinema_exam_practice.dto.out;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieSummaryListItem {
    private String title;
    private Integer numberOfScreenings;
    private Integer sumOfSoldTickets;

    public MovieSummaryListItem(Integer numberOfScreenings, Integer sumOfSoldTickets, String title) {
        this.title = title;
        this.numberOfScreenings = numberOfScreenings;
        this.sumOfSoldTickets = sumOfSoldTickets;
    }
}
