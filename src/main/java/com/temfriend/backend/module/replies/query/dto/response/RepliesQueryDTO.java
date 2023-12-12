package com.temfriend.backend.module.replies.query.dto.response;

import lombok.Builder;

import static com.temfriend.backend.module.replies.query.dto.response.RepliesQueryDTO.Get;

public sealed interface RepliesQueryDTO permits Get {
    @Builder
    record Get(
            Long id,
            String content,
            String nickname
    ) implements RepliesQueryDTO {
    }
}
