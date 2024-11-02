package com.tally.luckydraw.domain.entity;

import com.tally.luckydraw.global.domain.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "EVENT_PRODUCT_STOCKS")
public class EventProductStockEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "EVENT_PRODUCT_STOCK_ID")
    private Long id;

    @Version
    @Column(name = "VERSION")
    private Long version;

    @Column(name = "EVENT_PRODUCT_ID", nullable = false)
    private Long eventProductId;

    @Column(name = "STOCK_QUANTITY", nullable = false)
    private int currentQuantity;

}