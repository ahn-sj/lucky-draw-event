package com.tally.luckydraw.global.domain.period;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Embeddable
public class DateTimePeriod {

    @Column(name = "start_dt", nullable = false)
    private LocalDateTime startDt;

    @Column(name = "end_dt", nullable = false)
    private LocalDateTime endDt;

    private DateTimePeriod(final LocalDateTime startDt, final LocalDateTime endDt) {
        this.startDt = startDt;
        this.endDt = endDt;
    }

    protected DateTimePeriod() {}

    public static DateTimePeriod of(final LocalDateTime startDt, final LocalDateTime endDt) {
        return new DateTimePeriod(startDt, endDt);
    }

}
