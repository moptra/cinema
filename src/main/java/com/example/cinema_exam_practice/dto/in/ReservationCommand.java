package com.example.cinema_exam_practice.dto.in;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationCommand {
    private String name;
    private Integer reservedSeats;
    private String screeningTitle;

}
