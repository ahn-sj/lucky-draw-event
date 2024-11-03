package com.tally.luckydraw.domain;

import com.tally.luckydraw.domain.entity.EventProductEntity;
import com.tally.luckydraw.domain.entity.EventProductStockEntity;
import com.tally.luckydraw.global.annotation.DomainModel;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Getter
@DomainModel
public class EventProduct {

    private final Long eventProductId;
    private final String eventProductName;
    private final int maxQuantity;
    private final int currentQuantity;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private EventProduct(final Long eventProductId, final String eventProductName, final int maxQuantity, final int currentQuantity, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.eventProductId = eventProductId;
        this.eventProductName = eventProductName;
        this.maxQuantity = maxQuantity;
        this.currentQuantity = currentQuantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static List<EventProduct> of(final List<EventProductEntity> eventProducts, final List<EventProductStockEntity> productStocks) {
        final Map<Long, EventProductStockEntity> productStockMap = productStocks.stream()
                .collect(toMap(EventProductStockEntity::getEventProductId, eventProductStockEntity -> eventProductStockEntity));

        return eventProducts.stream()
                .map(eventProduct -> EventProduct.of(eventProduct, productStockMap.get(eventProduct.getId())))
                .toList();
    }

    private static EventProduct of(final EventProductEntity eventProductEntity, final EventProductStockEntity productStock) {
        return new EventProduct(
                eventProductEntity.getId(),
                eventProductEntity.getName(),
                eventProductEntity.getMaxQuantity(),
                productStock.getCurrentQuantity(),
                eventProductEntity.getCreatedAt(),
                eventProductEntity.getUpdatedAt()
        );
    }
}
