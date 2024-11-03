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

            return objectMapper.readValue(dbData, new TypeReference<>() {});
        } catch (Exception e) {
            throw new IllegalStateException("Failed to convert JSON to RankProbability list", e);
        }
    }

}
