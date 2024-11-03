package com.tally.luckydraw.persistence;

import com.tally.luckydraw.domain.entity.EventProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface EventProductJpaRepository extends JpaRepository<EventProductEntity, Long> {

    @Query("SELECT e FROM EventProductEntity e WHERE e.eventId = :eventId")
    List<EventProductEntity> findByEventId(Long eventId);

}
