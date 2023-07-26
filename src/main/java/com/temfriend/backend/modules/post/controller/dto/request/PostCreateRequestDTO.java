package com.temfriend.backend.modules.post.controller.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRequestDTO {
    private String content;
    private LocalDateTime startDt;
    private LocalDateTime endDt;

}
