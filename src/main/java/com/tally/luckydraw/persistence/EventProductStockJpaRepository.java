package com.tally.luckydraw.persistence;

import com.tally.luckydraw.domain.entity.EventProductStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventProductStockJpaRepository extends JpaRepository<EventProductStockEntity, Long> {

    @Query("SELECT e FROM EventProductStockEntity e WHERE e.eventProduct.id IN :ids")
    List<EventProductStockEntity> findByIds(List<Long> ids);

    @Query("SELECT eps FROM EventProductStockEntity eps JOIN FETCH eps.eventProduct ep WHERE ep.eventId = :eventId")
    List<EventProductStockEntity> findByEventId(Long eventId);

    @Query("SELECT eps FROM EventProductStockEntity eps JOIN FETCH eps.eventProduct ep WHERE ep.productId = :productId")
    Optional<EventProductStockEntity> findByProductId(Long productId);
}
