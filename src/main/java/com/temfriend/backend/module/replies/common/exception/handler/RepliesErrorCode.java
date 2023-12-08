package com.temfriend.backend.module.replies.common.exception.handler;

import com.temfriend.backend.global.common.exception.custom.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum RepliesErrorCode implements ExceptionCode {
    NOT_FOUNT_REPLIES_FROM_USERS(HttpStatus.NOT_FOUND, "해당 댓글은 존재하지 않습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;
}
