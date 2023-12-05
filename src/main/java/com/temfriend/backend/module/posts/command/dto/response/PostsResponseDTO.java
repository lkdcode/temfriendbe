package com.temfriend.backend.module.posts.command.dto.response;

import lombok.Builder;

import static com.temfriend.backend.module.posts.command.dto.response.PostsResponseDTO.*;

public sealed interface PostsResponseDTO permits Create, Update, Delete {
    @Builder
    record Create(
            Long id,
            String message
    ) implements PostsResponseDTO {
    }

    @Builder
    record Update(
            Long id,
            String message
    ) implements PostsResponseDTO {
    }

    @Builder
    record Delete(
            Long id,
            String message
    ) implements PostsResponseDTO {
    }
}
