package com.tally.luckydraw.application;

public interface EventParticipateService {

    void participate(final String eventId, final String userId);
    void getParticipatedResult(final String eventId, final String userId);

}
