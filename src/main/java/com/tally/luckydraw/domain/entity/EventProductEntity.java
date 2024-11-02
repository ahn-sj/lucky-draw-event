package com.tally.luckydraw.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "EVENT_PRODUCTS")
public class EventProductEntity {

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

    // TODO: 확장성 고려해서 코드단에서 관리하는게 더 나으려나? 아니면 DB에서 관리하는게 나으려나?
    @Column(name = "RANK")
    private int rank;

    @Column(name = "PROBABILITY", nullable = false)
    private double probability;

}
