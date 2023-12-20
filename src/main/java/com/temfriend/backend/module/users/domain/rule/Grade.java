package com.temfriend.backend.module.users.domain.rule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Grade {
    BRONZE,
    SILVER,
    GOLD,
    ;

    public static Grade From(String name) {
        return Arrays.stream(Grade.values())
                .filter(grade -> grade.name().equals(name))
                .findFirst()
                .orElse(BRONZE);
    }
}
