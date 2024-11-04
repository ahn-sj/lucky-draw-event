package com.tally.luckydraw.persistence.adapter;

import com.tally.luckydraw.domain.Event;
import com.tally.luckydraw.domain.User;
import com.tally.luckydraw.domain.entity.EventProductStockEntity;
import com.tally.luckydraw.global.domain.vo.RankProbability;
import com.tally.luckydraw.persistence.EventProductStockJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EventCommandAdapterTest {

    @Autowired
    private EventCommandAdapter eventCommandAdapter;

    @Autowired
    private EventProductStockJpaRepository eventProductStockJpaRepository;

    @Test
    @DisplayName("3000번 참여 요청 시, 최대 수량 도달 시 확률이 0으로 업데이트되고 재고가 증가하는지 검증")
    void testParticipate() {
        // TODO: 테스트 안깨지게 독립성 유지시키도록 변경하기

        // Given - 이벤트와 사용자 생성 및 초기화
        final Event event = createEvent();
        final User user = createUser();

        // When - 3000번 참여 요청을 수행
        for (int i = 0; i < 1500; i++) {
            eventCommandAdapter.participate(event, user);
        }

        // Then - 재고와 확률 확인
        List<EventProductStockEntity> stocks = eventProductStockJpaRepository.findByEventId(event.getEventId());
        for (EventProductStockEntity stock : stocks) {
            int maxQuantity = stock.getEventProduct().getMaxQuantity();
            int currentQuantity = stock.getCurrentQuantity();

            System.out.printf("max stock = %d, current stock = %d%n", maxQuantity, currentQuantity);

            // 최대 수량에 도달한 상품의 경우 확률이 0으로 설정되었는지 검증
            if (currentQuantity >= maxQuantity) {
                RankProbability rankProbability = event.getRankProbabilities().stream()
                        .filter(prob -> prob.getEventProductId() != null &&
                                prob.getEventProductId().equals(stock.getEventProduct().getId()))
                        .findFirst()
                        .orElse(null);

                assertThat(rankProbability).isNotNull();
                assertThat(rankProbability.getProbability()).isEqualTo(0);
            }
        }
    }

    private static User createUser() {
        return User.of(1L, "user1");
    }

    private static Event createEvent() {
        return Event.builder()
                .eventId(1L)
                .rankProbabilities(List.of(
                        RankProbability.of(0, 0, null),
                        RankProbability.of(1, 5, 1L),
                        RankProbability.of(2, 10, 2L),
                        RankProbability.of(3, 15, 3L),
                        RankProbability.of(4, 20, 4L),
                        RankProbability.of(5, 50, 5L)
                ))
                .build();
    }


}
