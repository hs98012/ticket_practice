package com.ticket.concert.service.response;

import com.ticket.concert.entity.ConcertSchedule;
import java.time.LocalDateTime;

public record ScheduleResponse(Long id, LocalDateTime performTime, int totalSeats) {
    public static ScheduleResponse from(ConcertSchedule schedule) {
        return new ScheduleResponse(schedule.getId(), schedule.getPerformTime(), schedule.getTotalSeats());
    }
}