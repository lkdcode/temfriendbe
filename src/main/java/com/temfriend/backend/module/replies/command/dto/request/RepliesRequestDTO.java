package com.temfriend.backend.module.replies.command.dto.request;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.temfriend.backend.module.replies.command.dto.request.RepliesRequestDTO.Create;
import static com.temfriend.backend.module.replies.command.dto.request.RepliesRequestDTO.Update;

public sealed interface RepliesRequestDTO permits Create, Update {
    @Builder
    record Create(
            @NotBlank(message = "댓글 내용을 입력해주세요.")
            @Size(min = 5, max = 100, message = "댓글 내용은 최소 5글자 최대 100글자입니다.")
            String content
    ) implements RepliesRequestDTO {
    }

    @Builder
    record Update(
            @NotBlank(message = "수정할 댓글의 내용을 입력해주세요.")
            @Size(min = 5, max = 100, message = "수정할 댓글의 내용은 최소 5글자 최대 100글자입니다.")
            String content
    ) implements RepliesRequestDTO {
    }
}
