package com.tally.luckydraw.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventType {

    LUCKY_DRAW("추첨"),
    ATTENDANCE("출석");

    private final String description;

}
