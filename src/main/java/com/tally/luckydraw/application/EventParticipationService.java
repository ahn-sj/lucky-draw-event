package com.tally.luckydraw.application;

public interface EventParticipationService {

    void participate(final Long eventId, final Long userId);
    void getParticipatedResult(final Long eventId, final Long userId);

}
