package com.temfriend.backend.module.posts.command.dto.response;

import lombok.Builder;

import static com.temfriend.backend.module.posts.command.dto.response.PostsCommandResponseDTO.*;

public sealed interface PostsCommandResponseDTO permits Create, Update, Delete {
    @Builder
    record Create(
            Long id,
            String message
    ) implements PostsCommandResponseDTO {
    }

    @Builder
    record Update(
            Long id,
            String message
    ) implements PostsCommandResponseDTO {
    }

    @Builder
    record Delete(
            Long id,
            String message
    ) implements PostsCommandResponseDTO {
    }
}
