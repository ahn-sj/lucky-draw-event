package com.tally.luckydraw.domain.entity;

import com.tally.luckydraw.domain.constant.EventStatus;
import com.tally.luckydraw.domain.constant.EventType;
import com.tally.luckydraw.global.domain.base.BaseTimeEntity;
import com.tally.luckydraw.global.domain.period.DateTimePeriod;
import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "EVENTS")
public class EventEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "EVENT_ID")
    private Long id;

    @Column(name = "EVENT_NAME", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "EVENT_TYPE", nullable = false)
    private EventType eventType;

    @Enumerated(EnumType.STRING)
    @Column(name = "EVENT_STATUS", nullable = false)
    private EventStatus eventStatus;

    // TODO: 더 확장 가능하게 설계해야 하나?
    //  ex) 주 단위 반복, 월/수/금, 주말만 등
    @Embedded
    private DateTimePeriod eventPeriod;

}
