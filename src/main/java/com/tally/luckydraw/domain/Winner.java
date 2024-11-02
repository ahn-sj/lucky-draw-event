package com.tally.luckydraw.domain;

import com.tally.luckydraw.global.annotation.DomainModel;

import java.time.LocalDateTime;

@DomainModel
public class Winner {

    private final Long winnerId;
    private final Long eventId;
    private final Long eventPeriodId;
    private final Long eventProductId;
    private final Long userId;
    private final LocalDateTime winningDt;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private Winner(final Long winnerId, final Long eventId, final Long eventPeriodId, final Long eventProductId, final Long userId, final LocalDateTime winningDt, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.winnerId = winnerId;
        this.eventId = eventId;
        this.eventPeriodId = eventPeriodId;
        this.eventProductId = eventProductId;
        this.userId = userId;
        this.winningDt = winningDt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
