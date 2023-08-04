package com.example.cinema_exam_practice.domain;

import com.example.cinema_exam_practice.dto.in.ScreeningCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String title;
    @Column (nullable = false)
    private LocalDateTime screeningDate;
    @Column (nullable = false)
    private Integer seats;
    @Column
    private String imageUrl;

    public Screening(ScreeningCommand screeningCommand) {
        this.title = screeningCommand.getTitle();
        this.screeningDate = screeningCommand.getScreeningDate();
        this.seats = screeningCommand.getSeats();
        this.imageUrl = screeningCommand.getImageUrl();
    }
}
