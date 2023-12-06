package com.temfriend.backend.module.posts.command.dto.request;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.temfriend.backend.module.posts.command.dto.request.PostsCommandRequestDTO.*;

public sealed interface PostsCommandRequestDTO permits Create, Update {
    @Builder
    record Create(
            @NotBlank(message = "제목을 입력해주세요.")
            @Size(min = 2, max = 50, message = "제목은 최소 2글자 최대 50글자입니다.")
            String title,
            @NotBlank(message = "내용을 입력해주세요.")
            @Size(min = 5, max = 2_000, message = "내용은 최소 5글자 최대 2,000글자입니다.")
            String content
    ) implements PostsCommandRequestDTO {
    }

    @Builder
    record Update(
            @NotBlank(message = "수정할 제목을 입력해주세요.")
            @Size(min = 2, max = 50, message = "수정할 제목은 최소 2글자 최대 50글자입니다.")
            String title,
            @NotBlank(message = "수정할 내용을 입력해주세요.")
            @Size(min = 5, max = 2_000, message = "수정할 내용은 최소 5글자 최대 2,000글자입니다.")
            String content
    ) implements PostsCommandRequestDTO {
    }
}
