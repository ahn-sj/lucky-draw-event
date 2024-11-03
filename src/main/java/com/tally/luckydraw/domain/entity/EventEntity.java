package com.tally.luckydraw.domain.entity;

import com.tally.luckydraw.domain.Event;
import com.tally.luckydraw.domain.constant.EventStatus;
import com.tally.luckydraw.domain.constant.EventType;
import com.tally.luckydraw.global.converter.RankProbabilityConverter;
import com.tally.luckydraw.global.domain.base.BaseTimeEntity;
import com.tally.luckydraw.global.domain.period.DateTimePeriod;
import com.tally.luckydraw.global.domain.vo.RankProbability;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private EventType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "EVENT_STATUS", nullable = false)
    private EventStatus status;

    // TODO: 더 확장 가능하게 설계해야 하나?
    //  ex) 주 단위 반복, 월/수/금, 주말만 등
    @Embedded
    private DateTimePeriod eventPeriod;

    @Convert(converter = RankProbabilityConverter.class)
    @Column(name = "RANK_PROBABILITIES", columnDefinition = "JSON")
    private List<RankProbability> rankProbabilities;

    protected EventEntity() {}

    public EventEntity(final Long id, final String name, final EventType type, final EventStatus status, final DateTimePeriod eventPeriod, final List<RankProbability> rankProbabilities) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.eventPeriod = eventPeriod;
        this.rankProbabilities = rankProbabilities;
    }

    public Event toDomain() {
        return new Event(id, name, type, status, eventPeriod, rankProbabilities, this.getCreatedAt(), this.getUpdatedAt());
    }

    public void soleOut(final List<RankProbability> rankProbabilities) {
        this.rankProbabilities = rankProbabilities;
    }
}
