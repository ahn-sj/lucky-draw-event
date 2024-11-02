package com.tally.luckydraw.global.domain.vo;

import lombok.Getter;

@Getter
public class Probability {

    private final double value;

    private Probability(final double value) {
        validateInRange(value);
        this.value = value;
    }

    public static Probability from(double value) {
        return new Probability(value);
    }

    private void validateInRange(double value) {
        if (value < 0.0 || value > 100.0) {
            throw new IllegalArgumentException("Probability must be between 0 and 100");
        }
    }

}
