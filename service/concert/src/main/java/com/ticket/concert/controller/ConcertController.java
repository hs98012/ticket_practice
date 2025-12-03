package com.ticket.concert.controller;

import com.ticket.concert.service.ConcertService;
import com.ticket.concert.service.response.ConcertResponse;
import com.ticket.concert.service.response.ScheduleResponse;
import com.ticket.concert.service.response.SeatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ConcertController {

    private final ConcertService concertService;

    // 1. 공연 목록 조회
    @GetMapping("/concerts")
    public ResponseEntity<List<ConcertResponse>> getConcerts() {
        return ResponseEntity.ok(concertService.getAllConcerts());
    }

    // 2. 특정 공연의 일정 조회
    @GetMapping("/concerts/{concertId}/schedules")
    public ResponseEntity<List<ScheduleResponse>> getSchedules(@PathVariable Long concertId) {
        return ResponseEntity.ok(concertService.getSchedules(concertId));
    }

    // 3. 특정 일정의 좌석 조회
    @GetMapping("/schedules/{scheduleId}/seats")
    public ResponseEntity<List<SeatResponse>> getSeats(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(concertService.getSeats(scheduleId));
    }
}