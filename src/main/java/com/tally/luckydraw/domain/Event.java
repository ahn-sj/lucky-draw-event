package com.tally.luckydraw.domain;

import com.tally.luckydraw.global.annotation.DomainModel;

import java.time.LocalDateTime;

@DomainModel
public class Event {

    private final Long eventId;
    private final String name;
    private final EventType eventType;
    private final EventStatus eventStatus;
    private final DateTimePeriod eventPeriod;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private Event(final Long eventId, final String name, final EventType eventType, final EventStatus eventStatus, final DateTimePeriod eventPeriod, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.eventId = eventId;
        this.name = name;
        this.eventType = eventType;
        this.eventStatus = eventStatus;
        this.eventPeriod = eventPeriod;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
