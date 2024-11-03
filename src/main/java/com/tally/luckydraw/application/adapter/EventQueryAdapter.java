package com.tally.luckydraw.application.adapter;

import com.tally.luckydraw.domain.Event;
import com.tally.luckydraw.domain.repository.EventQueryRepository;
import com.tally.luckydraw.persistence.EventJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventQueryAdapter implements EventQueryRepository {

    private final EventJpaRepository eventJpaRepository;

    @Override
    public Event getById(final Long eventId) {
        return eventJpaRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"))
                .toDomain();
    }
}
