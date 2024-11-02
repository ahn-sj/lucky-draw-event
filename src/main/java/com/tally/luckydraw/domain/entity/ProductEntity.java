package com.tally.luckydraw.domain.entity;

import com.tally.luckydraw.global.domain.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "PRODUCTS")
public class ProductEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String name;

    @Column(name = "PRODUCT_STATUS", nullable = false)
    private String status;

}
