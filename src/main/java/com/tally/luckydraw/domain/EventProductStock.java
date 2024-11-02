package com.tally.luckydraw.domain;

import com.tally.luckydraw.global.annotation.DomainModel;

import java.time.LocalDateTime;

@DomainModel
public class EventProductStock {

    private final Long eventProductStockId;
    private final Long eventProductId;
    private final Long eventPeriodId;
    private final Long currentQuantity;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public EventProductStock(final Long eventProductStockId, final Long eventProductId, final Long eventPeriodId, final Long currentQuantity, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.eventProductStockId = eventProductStockId;
        this.eventProductId = eventProductId;
        this.eventPeriodId = eventPeriodId;
        this.currentQuantity = currentQuantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
