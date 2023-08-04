package com.example.cinema_exam_practice.dto.in;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class ScreeningCommand {
    private String title;
    private LocalDateTime screeningDate;
    private Integer seats;
    private String imageUrl;
}
