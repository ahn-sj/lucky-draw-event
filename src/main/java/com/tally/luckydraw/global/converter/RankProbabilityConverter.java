package com.tally.luckydraw.global.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tally.luckydraw.global.domain.vo.RankProbability;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Collections;
import java.util.List;

@Converter
public class RankProbabilityConverter implements AttributeConverter<List<RankProbability>, String> {

    private final ObjectMapper objectMapper;

    public RankProbabilityConverter(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String convertToDatabaseColumn(final List<RankProbability> rankProbabilities) {
        try {
            if (rankProbabilities == null || rankProbabilities.isEmpty()) {
                return null;
            }

            validateProbabilitySum(rankProbabilities);
            return objectMapper.writeValueAsString(rankProbabilities);

        } catch (Exception e) {
            throw new IllegalStateException("Failed to convert RankProbability list to JSON", e);
        }
    }

    @Override
    public List<RankProbability> convertToEntityAttribute(final String dbData) {
        try {
            if (dbData == null || dbData.isEmpty()) {
                return Collections.emptyList();
            }

            List<RankProbability> rankProbabilities = objectMapper.readValue(dbData,
                    new TypeReference<List<RankProbability>>() {});

            validateProbabilitySum(rankProbabilities);
            return rankProbabilities;

        } catch (Exception e) {
            throw new IllegalStateException("Failed to convert JSON to RankProbability list", e);
        }
    }

    private void validateProbabilitySum(List<RankProbability> rankProbabilities) {
        double sum = rankProbabilities.stream()
                .mapToDouble(rp -> rp.getProbability().getValue())
                .sum();

        if (Math.abs(sum - 100.0) > 0.01) {  // 부동소수점 오차 고려
            throw new IllegalArgumentException("Total probability must be 100%");
        }
    }

}
