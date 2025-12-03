package com.ticket.concert.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertSchedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_id")
    private Concert concert;

    private LocalDateTime performTime;
    private int totalSeats;

    public ConcertSchedule(Concert concert, LocalDateTime performTime, int totalSeats) {
        this.concert = concert;
        this.performTime = performTime;
        this.totalSeats = totalSeats;
    }
}