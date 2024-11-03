package com.tally.luckydraw.domain.repository;

import com.tally.luckydraw.domain.User;

public interface UserQueryRepository {
    User getById(Long userId);
}
