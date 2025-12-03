package com.ticket.concert.repository;

import com.ticket.concert.entity.ConcertSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConcertScheduleRepository extends JpaRepository<ConcertSchedule, Long> {
    List<ConcertSchedule> findByConcertId(Long concertId);
}