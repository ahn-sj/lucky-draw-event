package com.tally.luckydraw.global.helper;

import com.tally.luckydraw.global.domain.vo.RankProbability;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LuckyDrawPickerTest {

    private LuckyDrawPicker luckyDrawPicker;

    @BeforeEach
    void setUp() {
        luckyDrawPicker = new LuckyDrawPicker();
    }

    @Test
    @DisplayName("확률에 따라 랭크를 추첨한다.")
    void testProbabilityDistribution() {
        // Given
        List<RankProbability> probabilities = List.of(
                RankProbability.of(0, 0, null),   // 꽝: 0%
                RankProbability.of(1, 5, 2L),   // 1등: 5%
                RankProbability.of(2, 10, 3L),  // 2등: 10%
                RankProbability.of(3, 15, 4L),  // 3등: 15%
                RankProbability.of(4, 20, 5L),  // 4등: 20%
                RankProbability.of(5, 50, 6L)   // 5등: 50%
        );

        // When
        Map<Integer, Integer> results = new HashMap<>();
        int expectedUserCount = 3_000;

        for (int i = 0; i < expectedUserCount; i++) {
            int rank = luckyDrawPicker.pick(probabilities);
            results.merge(rank, 1, Integer::sum);
        }

        // Then
        assertThat(results.getOrDefault(0, 0)).isEqualTo(0);
    }
}
