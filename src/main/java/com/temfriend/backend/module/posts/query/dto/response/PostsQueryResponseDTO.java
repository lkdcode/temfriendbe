package com.temfriend.backend.module.posts.query.dto.response;

import lombok.Builder;

import static com.temfriend.backend.module.posts.query.dto.response.PostsQueryResponseDTO.Get;

public sealed interface PostsQueryResponseDTO permits Get {
    @Builder
    record Get(
            String title,
            String content
    ) implements PostsQueryResponseDTO {
    }
}
