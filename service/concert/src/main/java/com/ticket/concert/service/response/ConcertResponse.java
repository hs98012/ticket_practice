package com.ticket.concert.service.response;

import com.ticket.concert.entity.Concert;

public record ConcertResponse(Long id, String title, String artist) {
    public static ConcertResponse from(Concert concert) {
        return new ConcertResponse(concert.getId(), concert.getTitle(), concert.getArtist());
    }
}