package com.temfriend.backend.module.posts.common.exception.enums;

import com.temfriend.backend.global.exception.custom.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostsException implements ExceptionCode {
    NOT_FOUNT_POSTS_FROM_ID(HttpStatus.NOT_FOUND, "해당 게시글은 존재하지 않습니다."),
    NOT_MATCHES(HttpStatus.UNAUTHORIZED, "해당 게시글의 작성자가 아닙니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;

}
