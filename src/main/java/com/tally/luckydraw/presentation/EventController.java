package com.tally.luckydraw.presentation;

import com.tally.luckydraw.application.impl.EventServiceUseCase;
import com.tally.luckydraw.application.model.EventQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventServiceUseCase eventService;

    @GetMapping("/events/{eventId}")
    public EventQuery.EventDetailedQuery getEvent(final @PathVariable Long eventId) {
        return eventService.getEvent(eventId);
    }
}
