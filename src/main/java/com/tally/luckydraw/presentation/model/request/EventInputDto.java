package com.tally.luckydraw.presentation.model.request;

import lombok.Getter;

public class EventInputDto {

    @Getter
    public static class LuckyDrawEventParticipateRequest {
        private Long userId;
    }

}
