package com.tally.luckydraw.application.model;

import com.tally.luckydraw.domain.Event;
import com.tally.luckydraw.domain.EventProduct;
import com.tally.luckydraw.domain.constant.EventStatus;
import com.tally.luckydraw.domain.constant.EventType;
import com.tally.luckydraw.global.domain.period.DateTimePeriod;
import com.tally.luckydraw.global.domain.vo.RankProbability;
import lombok.Getter;

import java.util.List;

public class EventQuery {

    @Getter
    public static class EventDetailedQuery {
        private final Long eventId;
        private final String eventName;
        private final EventType eventType;
        private final EventStatus eventStatus;
        private final DateTimePeriod eventPeriod;
        private final List<RankProbability> rankProbabilities;
        private final List<EventDetailedProductQuery> eventProducts;

        private EventDetailedQuery(final Long eventId, final String eventName, final EventType eventType, final EventStatus eventStatus, final DateTimePeriod eventPeriod, final List<RankProbability> rankProbabilities, final List<EventDetailedProductQuery> eventProducts) {
            this.eventId = eventId;
            this.eventName = eventName;
            this.eventType = eventType;
            this.eventStatus = eventStatus;
            this.eventPeriod = eventPeriod;
            this.rankProbabilities = rankProbabilities;
            this.eventProducts = eventProducts;
        }

        public static EventDetailedQuery of(final Event event, final List<EventProduct> eventProducts) {
            return new EventDetailedQuery(
                    event.getEventId(),
                    event.getEventName(),
                    event.getEventType(),
                    event.getEventStatus(),
                    event.getEventPeriod(),
                    event.getRankProbabilities(),
                    eventProducts.stream().map(EventDetailedProductQuery::of).toList());
        }
    }

    @Getter
    private static class EventDetailedProductQuery {
        private final Long eventProductId;
        private final String eventProductName;
        private final int maxQuantity;
        private final int currentQuantity;

        private EventDetailedProductQuery(final Long eventProductId, final String eventProductName, final int maxQuantity, final int currentQuantity) {
            this.eventProductId = eventProductId;
            this.eventProductName = eventProductName;
            this.maxQuantity = maxQuantity;
            this.currentQuantity = currentQuantity;
        }

        public static EventDetailedProductQuery of(final EventProduct eventProduct) {
            return new EventDetailedProductQuery(
                    eventProduct.getEventProductId(),
                    eventProduct.getEventProductName(),
                    eventProduct.getMaxQuantity(),
                    eventProduct.getCurrentQuantity()
            );
        }
    }
}
