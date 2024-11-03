package com.tally.luckydraw.persistence.adapter;

import com.tally.luckydraw.domain.EventProduct;
import com.tally.luckydraw.domain.entity.EventProductEntity;
import com.tally.luckydraw.domain.entity.EventProductStockEntity;
import com.tally.luckydraw.domain.repository.EventProductQueryRepository;
import com.tally.luckydraw.persistence.EventProductJpaRepository;
import com.tally.luckydraw.persistence.EventProductStockJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventProductQueryAdapter implements EventProductQueryRepository {

    private final EventProductJpaRepository eventProductJpaRepository;
    private final EventProductStockJpaRepository eventProductStockJpaRepository;

    @Override
    public List<EventProduct> getByEventId(Long eventId) {
        // 이벤트 상품 조회
        final List<EventProductEntity> eventProducts = eventProductJpaRepository.findByEventId(eventId);

        // 이벤트 상품의 재고 조회
        final List<Long> eventProductIds = eventProducts.stream()
                .map(EventProductEntity::getId)
                .toList();
        final List<EventProductStockEntity> productStocks = eventProductStockJpaRepository.findByIds(eventProductIds);

        return EventProduct.of(eventProducts, productStocks);
    }

    @Override
    public void checkStock(final Long eventId) {
        // 이벤트 상품 & 상품 재고 조회
        final List<EventProductStockEntity> productStocks = eventProductStockJpaRepository.findByEventId(eventId);

        // 재고가 충분한 상품이 있는지 확인
        productStocks.stream()
                .filter(EventProductStockEntity::isSufficient)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Stock is not enough"));
    }
}
