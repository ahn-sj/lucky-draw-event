package com.tally.luckydraw.domain.entity;

import com.tally.luckydraw.global.domain.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "EVENT_PRODUCTS")
public class EventProductEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "EVENT_PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "EVENT_ID", nullable = false)
    private Long eventId;

    @Column(name = "EVENT_PRODUCT_NAME", nullable = false)
    private String name;

    @Column(name = "MAX_QUANTITY", nullable = false)
    private int maxQuantity;

}
