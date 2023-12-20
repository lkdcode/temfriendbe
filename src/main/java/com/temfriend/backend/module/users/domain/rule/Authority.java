package com.temfriend.backend.module.users.domain.rule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Authority {
    USERS,
    ADMIN,
    ;

    public static Authority from(String name) {
        return Arrays.stream(Authority.values())
                .filter(auth -> auth.name().equals(name))
                .findFirst()
                .orElse(USERS);
    }
}
