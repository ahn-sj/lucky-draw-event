package com.tally.luckydraw.application.impl;

import com.tally.luckydraw.application.EventParticipateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventParticipateServiceImpl implements EventParticipateService {

    @Override
    public void participate(final String eventId, final String userId) {

    }

    @Override
    public void getParticipatedResult(final String eventId, final String userId) {

    }
}
