package com.ticket.concert.service;

import com.ticket.concert.service.response.*;
import com.ticket.concert.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기 전용으로 성능 최적화
public class ConcertService {

    private final ConcertRepository concertRepository;
    private final ConcertScheduleRepository scheduleRepository;
    private final SeatRepository seatRepository;

    public List<ConcertResponse> getAllConcerts() {
        return concertRepository.findAll().stream()
                .map(ConcertResponse::from)
                .collect(Collectors.toList());
    }

    public List<ScheduleResponse> getSchedules(Long concertId) {
        return scheduleRepository.findByConcertId(concertId).stream()
                .map(ScheduleResponse::from)
                .collect(Collectors.toList());
    }

    public List<SeatResponse> getSeats(Long scheduleId) {
        return seatRepository.findByScheduleId(scheduleId).stream()
                .map(SeatResponse::from)
                .collect(Collectors.toList());
    }
}