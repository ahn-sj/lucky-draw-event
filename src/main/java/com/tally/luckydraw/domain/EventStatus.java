package com.tally.luckydraw.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventStatus {

    READY("준비중"),
    IN_PROGRESS("진행중"),
    FINISHED("종료됨"),
    CANCELLED("취소됨");

    private final String description;
}
