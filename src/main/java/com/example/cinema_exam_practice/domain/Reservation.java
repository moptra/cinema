package com.example.cinema_exam_practice.domain;

import com.example.cinema_exam_practice.dto.in.ReservationCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column (nullable = false)
    private Integer reservedSeats;
    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;

    public Reservation(ReservationCommand reservationCommand, Screening screening) {
        this.name = reservationCommand.getName();
        this.reservedSeats = reservationCommand.getReservedSeats();
        this.screening = screening;
    }
}
