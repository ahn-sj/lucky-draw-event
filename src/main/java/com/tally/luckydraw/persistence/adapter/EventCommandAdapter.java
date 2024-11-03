package com.tally.luckydraw.persistence.adapter;

import com.tally.luckydraw.domain.entity.EventEntity;
import com.tally.luckydraw.domain.repository.EventCommandRepository;
import com.tally.luckydraw.persistence.EventJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventCommandAdapter implements EventCommandRepository {

    private final EventJpaRepository eventJpaRepository;

    @Override
    public EventEntity store(final EventEntity event) {
        return eventJpaRepository.save(event);
    }
}
