package com.tally.luckydraw.global.domain.vo;

import com.tally.luckydraw.domain.constant.Rank;
import lombok.Getter;

@Getter
public class RankProbability {
    private final Rank rank;
    private final Probability probability;

    private RankProbability(final Rank rank, final Probability probability) {
        this.rank = rank;
        this.probability = probability;
    }

    public static RankProbability of(final Rank rank, final Probability probability) {
        return new RankProbability(rank, probability);
    }

    public static RankProbability of(final int rankValue, final double probabilityValue) {
        return new RankProbability(
                Rank.from(rankValue),
                Probability.from(probabilityValue)
        );
    }
}
