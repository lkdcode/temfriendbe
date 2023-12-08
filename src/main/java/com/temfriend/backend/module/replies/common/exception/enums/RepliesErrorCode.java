package com.temfriend.backend.module.replies.common.exception.enums;

import com.temfriend.backend.global.common.exception.custom.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum RepliesErrorCode implements ExceptionCode {
    NOT_FOUNT_REPLIES_FROM_ID(HttpStatus.NOT_FOUND, "해당 댓글은 존재하지 않습니다."),
    NOT_FOUNT_REPLIES_FROM_USERS(HttpStatus.NOT_FOUND, "해당 댓글은 존재하지 않습니다."),
    NOT_MATCHES(HttpStatus.UNAUTHORIZED, "해당 댓글의 작성자가 아닙니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;
}
