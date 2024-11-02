package com.tally.luckydraw.domain;

import com.tally.luckydraw.global.annotation.DomainModel;

@DomainModel
public class User {

    private final Long userId;
    private final String name;

    private User(final Long userId, final String name) {
        this.userId = userId;
        this.name = name;
    }

    public static User of(final Long userId, final String name) {
        return new User(userId, name);
    }

}
