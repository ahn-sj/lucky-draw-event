package com.tally.luckydraw.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventType {

    LUCKY_DRAW("추첨");

    private final String description;

}