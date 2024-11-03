package com.tally.luckydraw.persistence.adapter;

import com.tally.luckydraw.domain.User;
import com.tally.luckydraw.domain.repository.UserQueryRepository;
import com.tally.luckydraw.persistence.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserQueryAdapter implements UserQueryRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User getById(final Long userId) {
        return userJpaRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"))
                .toDomain();
    }
}
