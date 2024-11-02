package com.tally.luckydraw.domain.entity;

import com.tally.luckydraw.global.converter.RankProbabilityConverter;
import com.tally.luckydraw.global.domain.vo.RankProbability;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

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

    @Convert(converter = RankProbabilityConverter.class)
    @Column(name = "RANK_PROBABILITIES", columnDefinition = "JSON")
    private List<RankProbability> rankProbabilities;

    @Column(name = "PROBABILITY")
    private double probability;

}
