package com.temfriend.backend.module.users.auth.dto.response;

import lombok.Builder;

import static com.temfriend.backend.module.users.auth.dto.response.AuthResponseDTO.*;

public sealed interface AuthResponseDTO permits LogIn, LogOut {
    @Builder
    record LogIn(
            String message,
            String accessToken
    ) implements AuthResponseDTO {
    }

    @Builder
    record LogOut(
            String message
    ) implements AuthResponseDTO {
    }
}
