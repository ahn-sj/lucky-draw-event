package com.tally.luckydraw.domain.repository;

import com.tally.luckydraw.domain.Event;
import com.tally.luckydraw.domain.User;
import com.tally.luckydraw.domain.entity.EventEntity;

public interface EventCommandRepository {

    EventEntity store(final EventEntity event);

    void participate(Event event, User user);
}
