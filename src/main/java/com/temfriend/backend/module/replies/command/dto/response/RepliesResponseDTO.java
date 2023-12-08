package com.temfriend.backend.module.replies.command.dto.response;

import lombok.Builder;

import static com.temfriend.backend.module.replies.command.dto.response.RepliesResponseDTO.*;

public sealed interface RepliesResponseDTO permits Create, Update, Delete {
    @Builder
    record Create(
            Long id,
            String content
    ) implements RepliesResponseDTO {
    }

    @Builder
    record Update(
            Long id,
            String content
    ) implements RepliesResponseDTO {
    }

    @Builder
    record Delete(
            String message
    ) implements RepliesResponseDTO {
    }
}
