package com.tally.luckydraw.global.domain.period;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class DateTimePeriod {

    private LocalDateTime startDt;
    private LocalDateTime endDt;

    protected DateTimePeriod() {}

    private DateTimePeriod(final LocalDateTime startDt, final LocalDateTime endDt) {
        this.startDt = startDt;
        this.endDt = endDt;
    }

    public static DateTimePeriod of(final LocalDateTime startDt, final LocalDateTime endDt) {
        return new DateTimePeriod(startDt, endDt);
    }

}
