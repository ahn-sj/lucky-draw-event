package com.tally.luckydraw.persistence;

import com.tally.luckydraw.domain.entity.EventProductStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventProductStockJpaRepository extends JpaRepository<EventProductStockEntity, Long> {
}
