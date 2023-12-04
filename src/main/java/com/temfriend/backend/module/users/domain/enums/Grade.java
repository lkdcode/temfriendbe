package com.temfriend.backend.module.users.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Grade {
    BRONZE,
    SILVER,
    GOLD,
    ;

    public static Grade From(String name) {
        switch (name) {
            case "SILVER" -> {
                return Grade.SILVER;
            }
            case "GOLD" -> {
                return Grade.GOLD;
            }
            case default, null, "BRONZE" -> {
                return Grade.BRONZE;
            }
        }
    }
}
