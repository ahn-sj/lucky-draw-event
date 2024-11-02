package com.tally.luckydraw.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Rank {

    NONE(0, "꽝"),
    FIRST(1, "1등"),
    SECOND(2, "2등"),
    THIRD(3, "3등");

    private final int value;
    private final String description;

    public static Rank from(int value) {
        return Arrays.stream(values())
                .filter(rank -> rank.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid value: " + value)); // TODO: 예외 공통화 필요
    }

}
