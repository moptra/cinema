package com.example.cinema_exam_practice.domain;

import com.example.cinema_exam_practice.dto.in.ScreeningCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "screening_id")
    private Long id;
    @Column (nullable = false)
    private String title;
    @Column (nullable = false)
    private LocalDateTime screeningDate;
    @Column (nullable = false)
    private Integer seats;
    @Column
    private String imageUrl;
    @OneToMany(mappedBy = "screening", fetch = FetchType.EAGER)
    private List<Reservation> reservations = new ArrayList<>();

    public Screening(ScreeningCommand screeningCommand) {
        this.title = screeningCommand.getTitle();
        this.screeningDate = screeningCommand.getScreeningDate();
        this.seats = screeningCommand.getSeats();
        this.imageUrl = screeningCommand.getImageUrl();


    }
}
