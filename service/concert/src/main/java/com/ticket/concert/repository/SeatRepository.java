package com.ticket.concert.repository;

import com.ticket.concert.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByScheduleId(Long scheduleId);
}