package com.ticket.concert.service.response;

import com.ticket.concert.entity.Seat;

public record SeatResponse(Long id, int seatNo, String status) {
    public static SeatResponse from(Seat seat) {
        return new SeatResponse(seat.getId(), seat.getSeatNo(), seat.getStatus().name());
    }
}