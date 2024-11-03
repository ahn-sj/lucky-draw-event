package com.tally.luckydraw.domain;

import com.tally.luckydraw.domain.constant.EventStatus;
import com.tally.luckydraw.domain.constant.EventType;
import com.tally.luckydraw.domain.entity.EventEntity;
import com.tally.luckydraw.global.annotation.DomainModel;
import com.tally.luckydraw.global.domain.period.DateTimePeriod;
import com.tally.luckydraw.global.domain.vo.RankProbability;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@DomainModel
public class Event {

    private final Long eventId;
    private final String eventName;
    private final EventType eventType;
    private final EventStatus eventStatus;
    private final DateTimePeriod eventPeriod;
    private List<RankProbability> rankProbabilities;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    @Builder
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

    public Long getWinningProductId(final int rank) {
        return rankProbabilities.stream()
                .filter(rankProbability -> rankProbability.getRank() == rank)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Rank not found"))
                .getEventProductId();
    }

    public List<RankProbability> setOutOfStock(final Long eventProductId) {
        return rankProbabilities.stream()
                .map(rankProbability -> rankProbability.isMatch(eventProductId) ? rankProbability.soldOut() : rankProbability)
                .collect(Collectors.toList());
    }

    public EventEntity toEntity() {
        return new EventEntity(eventId, eventName, eventType, eventStatus, eventPeriod, rankProbabilities);
    }
}
