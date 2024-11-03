package com.tally.luckydraw.global.helper;

import com.tally.luckydraw.global.domain.vo.RankProbability;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class LuckyDrawPicker {

    private final Random random = new Random();

    public int pick(List<RankProbability> rankProbabilities) {
        // 전체 확률의 합을 계산
        final double totalProbability = rankProbabilities.stream()
                .mapToDouble(RankProbability::getProbability)
                .sum();

        // 난수 생성
        final double randomValue = random.nextDouble() * totalProbability;

        // 랭크 추첨
        return drawRank(rankProbabilities, randomValue);
    }

    public int drawRank(final List<RankProbability> rankProbabilities, final double randomValue) {
        double cumulativeProbability = 0.0;
        for (RankProbability rankProbability : rankProbabilities) {
            cumulativeProbability += rankProbability.getProbability();
            if (randomValue < cumulativeProbability) {
                return rankProbability.getRank();
            }
        }
        return 0;
    }

}
