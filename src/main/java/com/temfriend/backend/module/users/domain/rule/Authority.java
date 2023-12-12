package com.temfriend.backend.module.users.domain.rule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Authority {
    USERS,
    ADMIN,
    ;

    public static Authority from(String name) {
        switch (name) {
            case "ADMIN" -> {
                return Authority.ADMIN;
            }
            case default, "USERS" -> {
                return Authority.USERS;
            }
        }
    }
}
