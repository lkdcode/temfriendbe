package com.temfriend.backend.module.users.signup.dto.rseponse;

import lombok.Builder;

import static com.temfriend.backend.module.users.signup.dto.rseponse.UsersSignUpResponse.*;

public sealed interface UsersSignUpResponse permits Create {
    @Builder
    record Create(
            String message
    ) implements UsersSignUpResponse {
    }
}
