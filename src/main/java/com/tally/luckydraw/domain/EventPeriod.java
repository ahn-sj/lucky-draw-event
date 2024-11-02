package com.tally.luckydraw.domain;

public class EventPeriod {
    private final Long eventPeriodId;
    private final String name;

    private EventPeriod(final Long eventPeriodId, final String name) {
        this.eventPeriodId = eventPeriodId;
        this.name = name;
    }

    public static EventPeriod of(final Long eventPeriodId, final String name) {
        return new EventPeriod(eventPeriodId, name);
    }

    public Long getEventPeriodId() {
        return eventPeriodId;
    }

    public String getName() {
        return name;
    }
}
