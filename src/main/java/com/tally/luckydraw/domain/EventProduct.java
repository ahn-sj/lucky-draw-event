package com.tally.luckydraw.domain;

import com.tally.luckydraw.domain.constant.ProductStatus;
import com.tally.luckydraw.global.annotation.DomainModel;

import java.time.LocalDateTime;

@DomainModel
public class EventProduct {

    private final Long productId;
    private final Long eventProductId;
    private final Long eventProductStockId;
    private final String eventProductName;
    private final int maxQuantity;
    private final int currentQuantity;
    private final int rank;
    private final double probability;
    private final ProductStatus productStatus;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private EventProduct(final Long productId, final Long eventProductId, final Long eventProductStockId, final String eventProductName, final int maxQuantity, final int currentQuantity, final int rank, final double probability, final ProductStatus productStatus, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.productId = productId;
        this.eventProductId = eventProductId;
        this.eventProductStockId = eventProductStockId;
        this.eventProductName = eventProductName;
        this.maxQuantity = maxQuantity;
        this.currentQuantity = currentQuantity;
        this.rank = rank;
        this.probability = probability;
        this.productStatus = productStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static EventProduct of(final Long productId, final Long eventProductId, final Long eventProductStockId, final String eventProductName, final int maxQuantity, final int currentQuantity, final int rank, final double probability, final ProductStatus productStatus, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        return new EventProduct(productId, eventProductId, eventProductStockId, eventProductName, maxQuantity, currentQuantity, rank, probability, productStatus, createdAt, updatedAt);
    }

}
