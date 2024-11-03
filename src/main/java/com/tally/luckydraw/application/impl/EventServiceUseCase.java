package com.tally.luckydraw.application.impl;

import com.tally.luckydraw.domain.Event;
import com.tally.luckydraw.domain.EventProduct;
import com.tally.luckydraw.domain.repository.EventCommandRepository;
import com.tally.luckydraw.domain.repository.EventProductQueryRepository;
import com.tally.luckydraw.domain.repository.EventQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tally.luckydraw.application.model.EventQuery.EventDetailedQuery;

@Service
@RequiredArgsConstructor
public class EventServiceUseCase {

    private final EventCommandRepository eventCommandRepository;
    private final EventQueryRepository eventQueryRepository;
    private final EventProductQueryRepository eventProductQueryRepository;

    public EventDetailedQuery getEvent(final Long eventId) {
        final Event event = eventQueryRepository.getById(eventId);
        final List<EventProduct> eventProducts = eventProductQueryRepository.getByEventId(eventId);

        return EventDetailedQuery.of(event, eventProducts);
    }

}
