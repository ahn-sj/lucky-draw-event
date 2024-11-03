package com.tally.luckydraw.application.impl;

import com.tally.luckydraw.application.EventParticipationService;
import com.tally.luckydraw.domain.Event;
import com.tally.luckydraw.domain.User;
import com.tally.luckydraw.domain.repository.EventCommandRepository;
import com.tally.luckydraw.domain.repository.EventProductQueryRepository;
import com.tally.luckydraw.domain.repository.EventQueryRepository;
import com.tally.luckydraw.domain.repository.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EventParticipationUseCase implements EventParticipationService {

    private final EventQueryRepository eventQueryRepository;
    private final EventProductQueryRepository eventProductQueryRepository;
    private final UserQueryRepository userQueryRepository;

    private final EventCommandRepository eventCommandRepository;

    @Override
    @Transactional
    public void participate(final Long eventId, final Long userId) {
        final Event event = eventQueryRepository.getById(eventId);
        final User user = userQueryRepository.getById(userId);

        // 재고 확인
        eventProductQueryRepository.checkStock(eventId);

        // 재고 차감 및 참여 이력 저장
        eventCommandRepository.participate(event, user);
    }

    @Override
    public void getParticipatedResult(final Long eventId, final Long userId) {

    }
}
