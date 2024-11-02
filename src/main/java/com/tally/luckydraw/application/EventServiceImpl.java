package com.tally.luckydraw.application;

import com.tally.luckydraw.domain.repository.EventCommandRepository;
import com.tally.luckydraw.domain.repository.EventQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl {

    private final EventCommandRepository eventCommandRepository;
    private final EventQueryRepository eventQueryRepository;

    public void createEvent(final String eventId, final String eventName) {

    }

}
