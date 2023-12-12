package com.temfriend.backend.module.posts.global.exception.enums;

import com.temfriend.backend.global.common.exception.custom.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostsErrorCode implements ErrorCode {
    NOT_FOUNT_POSTS_FROM_ID("POSTS-001", HttpStatus.NOT_FOUND, "해당 게시글은 존재하지 않습니다."),
    NOT_MATCHES("POSTS-002", HttpStatus.UNAUTHORIZED, "해당 게시글의 작성자가 아닙니다."),
    ;
    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}
