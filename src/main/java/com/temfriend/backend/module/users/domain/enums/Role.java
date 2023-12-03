package com.temfriend.backend.module.users.domain.enums;

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
            case "ADMIN" -> {
                return ROLE_ADMIN;
            }
            default -> {
                return ROLE_USER;
            }
        }
    }
}
