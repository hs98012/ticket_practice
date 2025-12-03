package com.ticket.concert;

import com.ticket.concert.entity.*;
import com.ticket.concert.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ConcertRepository concertRepository;
    private final ConcertScheduleRepository scheduleRepository;
    private final SeatRepository seatRepository;

    @Override
    public void run(String... args) throws Exception {
        if (concertRepository.count() > 0) return; // 데이터 있으면 패스

        // 1. 공연 생성
        Concert concert = new Concert("아이유 2024 콘서트", "아이유");
        concertRepository.save(concert);

        // 2. 일정 생성
        ConcertSchedule schedule = new ConcertSchedule(concert, LocalDateTime.now().plusDays(10), 50);
        scheduleRepository.save(schedule);

        // 3. 좌석 10개 생성
        for (int i = 1; i <= 10; i++) {
            seatRepository.save(new Seat(schedule, i));
        }

        System.out.println("========== 초기 데이터 세팅 완료 ==========");
    }
}