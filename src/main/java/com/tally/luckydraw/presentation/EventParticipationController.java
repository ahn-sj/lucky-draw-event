package com.tally.luckydraw.presentation;

import com.tally.luckydraw.application.EventParticipationService;
import com.tally.luckydraw.presentation.model.request.EventInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventParticipationController {

    private final EventParticipationService eventParticipationService;

    /**
     * 럭키드로우 이벤트 참여
     */
    @PostMapping("/events/{eventId}/participations/lucky-draw")
    public void participateInLuckyDraw(
            final @PathVariable Long eventId,
            final @RequestBody EventInputDto.LuckyDrawEventParticipateRequest request
    ) {
        eventParticipationService.participate(eventId, request.getUserId());
    }

    /**
     * 이벤트 참여 이력 조회
     */
    @PostMapping("/events/{eventId}/participations/{userId}")
    public void getParticipatedResult(
            final @PathVariable Long eventId,
            final @PathVariable Long userId
    ) {
        eventParticipationService.getParticipatedResult(eventId, userId);
    }
}
