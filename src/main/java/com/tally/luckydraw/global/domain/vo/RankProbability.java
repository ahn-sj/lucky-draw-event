package com.tally.luckydraw.global.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RankProbability {
    private final int rank;
    private final double probability;
    private final Long eventProductId;

    @JsonCreator  // Jackson 역직렬화를 위한 생성자
    public RankProbability(
            @JsonProperty("rank") final int rank,
            @JsonProperty("probability") final double probability,
            @JsonProperty("eventProductId") final Long eventProductId
    ) {
        this.rank = rank;
        this.probability = probability;
        this.eventProductId = eventProductId;
    }

    public static RankProbability of(final int rank, final double probability, final Long eventProductId) {
        return new RankProbability(rank, probability, eventProductId);
    }
}
