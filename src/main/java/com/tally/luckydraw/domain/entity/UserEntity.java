package com.tally.luckydraw.domain.entity;

import com.tally.luckydraw.domain.User;
import com.tally.luckydraw.global.domain.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "USERS")
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    public User toDomain() {
        return User.of(id, name);
    }
}
