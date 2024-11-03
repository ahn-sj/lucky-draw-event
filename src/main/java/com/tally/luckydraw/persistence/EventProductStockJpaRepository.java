package com.tally.luckydraw.persistence;

import com.tally.luckydraw.domain.entity.EventProductStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventProductStockJpaRepository extends JpaRepository<EventProductStockEntity, Long> {

    @Query("SELECT e FROM EventProductStockEntity e WHERE e.eventProductId IN :ids")
    List<EventProductStockEntity> findByIds(List<Long> ids);

}
