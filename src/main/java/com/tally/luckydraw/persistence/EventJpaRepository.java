package com.tally.luckydraw.persistence;

import com.tally.luckydraw.domain.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepository extends JpaRepository<EventEntity, Long> {
}
