package com.tally.luckydraw.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductStatus {

    ACTIVE("활성화됨"),
    INACTIVE("비활성화됨"),
    DELETED("삭제됨");

    private final String description;

}
