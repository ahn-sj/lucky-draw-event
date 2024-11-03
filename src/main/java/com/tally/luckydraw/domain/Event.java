package com.tally.luckydraw.domain;

import com.tally.luckydraw.domain.constant.EventStatus;
import com.tally.luckydraw.domain.constant.EventType;
import com.tally.luckydraw.global.annotation.DomainModel;
import com.tally.luckydraw.global.domain.period.DateTimePeriod;
import com.tally.luckydraw.global.domain.vo.RankProbability;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@DomainModel
public class Event {

    private final Long eventId;
    private final String eventName;
    private final EventType eventType;
    private final EventStatus eventStatus;
    private final DateTimePeriod eventPeriod;
    private final List<RankProbability> rankProbabilities;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Event(final Long eventId, final String eventName, final EventType eventType, final EventStatus eventStatus, final DateTimePeriod eventPeriod, final List<RankProbability> rankProbabilities, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventStatus = eventStatus;
        this.eventPeriod = eventPeriod;
        this.rankProbabilities = rankProbabilities;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
