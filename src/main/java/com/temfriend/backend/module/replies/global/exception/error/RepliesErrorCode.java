package com.temfriend.backend.module.replies.global.exception.error;

import com.temfriend.backend.global.common.exception.custom.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum RepliesErrorCode implements ErrorCode {
    NOT_FOUNT_REPLIES_FROM_ID("REPLIES-001", HttpStatus.NOT_FOUND, "해당 댓글은 존재하지 않습니다."),
    NOT_FOUNT_REPLIES_FROM_USERS("REPLIES-002", HttpStatus.NOT_FOUND, "해당 댓글은 존재하지 않습니다."),
    NOT_MATCHES("REPLIES-003", HttpStatus.UNAUTHORIZED, "해당 댓글의 작성자가 아닙니다."),
    ;
    private final String code;
    private final HttpStatus httpStatus;
    private final String message;

}
