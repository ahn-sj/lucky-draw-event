package com.tally.luckydraw.domain.repository;

import com.tally.luckydraw.domain.Event;

public interface EventQueryRepository {
    Event getById(Long eventId);

}
