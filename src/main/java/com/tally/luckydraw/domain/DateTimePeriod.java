package com.tally.luckydraw.domain;

import java.time.LocalDateTime;

public class DateTimePeriod {

    private final LocalDateTime startDt;
    private final LocalDateTime endDt;

    public DateTimePeriod(final LocalDateTime startDt, final LocalDateTime endDt) {
        this.startDt = startDt;
        this.endDt = endDt;
    }
}
