package com.tally.luckydraw.persistence.adapter;

import com.tally.luckydraw.domain.Event;
import com.tally.luckydraw.domain.User;
import com.tally.luckydraw.domain.entity.EventEntity;
import com.tally.luckydraw.domain.entity.EventProductStockEntity;
import com.tally.luckydraw.domain.repository.EventCommandRepository;
import com.tally.luckydraw.global.helper.LuckyDrawPicker;
import com.tally.luckydraw.persistence.EventJpaRepository;
import com.tally.luckydraw.persistence.EventProductStockJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class EventCommandAdapter implements EventCommandRepository {

    private final EventJpaRepository eventJpaRepository;
    private final EventProductStockJpaRepository eventProductStockJpaRepository;

    private final LuckyDrawPicker luckyDrawPicker;

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

        final EventProductStockEntity stock = eventProductStockJpaRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("not found product"));
        stock.increase();

        // TODO: 최대 수량 도달 시 상품 판매 종료 처리
        if (stock.isSufficient()) {
            updateRankProbability(event, rank);
        }

        // TODO: 참여 이력 저장

    }

    private void updateRankProbability(final Event event, final int rank) {

    }
}
