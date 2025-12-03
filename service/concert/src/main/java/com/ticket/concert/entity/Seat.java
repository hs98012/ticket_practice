package com.ticket.concert.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private ConcertSchedule schedule;

    private int seatNo;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    public Seat(ConcertSchedule schedule, int seatNo) {
        this.schedule = schedule;
        this.seatNo = seatNo;
        this.status = SeatStatus.AVAILABLE;
    }
}