package com.tally.luckydraw.domain;

import com.tally.luckydraw.global.annotation.DomainModel;

import java.time.LocalDateTime;

@DomainModel
public class Product {

    private final Long productId;
    private final String productName;
    private final int rank;
    private final double probability;
    private final int maxQuantity;
    private final ProductStatus productStatus;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Product(final Long productId, final String productName, final int rank, final double probability, final int maxQuantity, final ProductStatus productStatus, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.productId = productId;
        this.productName = productName;
        this.rank = rank;
        this.probability = probability;
        this.maxQuantity = maxQuantity;
        this.productStatus = productStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
