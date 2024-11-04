package com.tally.luckydraw.persistence.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tally.luckydraw.domain.Event;
import com.tally.luckydraw.domain.User;
import com.tally.luckydraw.domain.entity.EventEntity;
import com.tally.luckydraw.domain.entity.EventProductStockEntity;
import com.tally.luckydraw.domain.repository.EventCommandRepository;
import com.tally.luckydraw.global.domain.vo.RankProbability;
import com.tally.luckydraw.global.helper.LuckyDrawPicker;
import com.tally.luckydraw.persistence.EventJpaRepository;
import com.tally.luckydraw.persistence.EventProductStockJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventCommandAdapter implements EventCommandRepository {

    private final EventJpaRepository eventJpaRepository;
    private final EventProductStockJpaRepository eventProductStockJpaRepository;

    private final LuckyDrawPicker luckyDrawPicker;

    private final ObjectMapper objectMapper;

    @Override
    @Transactional
    public EventEntity store(final EventEntity event) {
        return eventJpaRepository.save(event);
    }

    @Override
    @Transactional
    public void participate(final Event event, final User user) {
        final int rank = luckyDrawPicker.pick(event.getRankProbabilities());

        final Long productId = event.getWinningProductId(rank);

        // 상품 재고 증가
        final EventProductStockEntity stock = getProductStock(productId);
        stock.increase();

        // 최대 수량 도달 시 상품 판매 종료 처리
        if (stock.isSufficient()) {
            return;
        }

        log.info("sold out - {}", productId);

        final EventEntity eventEntity = eventJpaRepository.findById(event.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        final List<RankProbability> probabilities = event.getRankProbabilities()
                .stream()
                .map(probability -> probability.getRank() == rank
                        ? probability.with(0.0)
                        : probability
                )
                .toList();
        eventEntity.soleOut(probabilities);

        eventJpaRepository.save(eventEntity);
    }

    private EventProductStockEntity getProductStock(final Long productId) {
        return eventProductStockJpaRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("not found product"));
    }

}
