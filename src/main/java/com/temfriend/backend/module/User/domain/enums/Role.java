package com.temfriend.backend.module.User.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    private final String role;

    public static Role from(String role) {
        switch (role) {
            case "USER" -> {
                return ROLE_USER;
            }
            case "ADMIN" -> {
                return ROLE_ADMIN;
            }
            default -> {
                // TODO : CustomException 적용
                throw new IllegalArgumentException("존재하지 않는 권한입니다.");
            }
        }
    }
}
