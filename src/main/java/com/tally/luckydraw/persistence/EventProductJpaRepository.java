package com.tally.luckydraw.persistence;

import com.tally.luckydraw.domain.entity.EventProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventProductJpaRepository extends JpaRepository<EventProductEntity, Long> {
}
