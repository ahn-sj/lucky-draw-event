package com.tally.luckydraw.domain.repository;

import com.tally.luckydraw.domain.EventProduct;

import java.util.List;

public interface EventProductQueryRepository {

    List<EventProduct> getByEventId(Long eventId);

    void checkStock(Long eventId);

}
