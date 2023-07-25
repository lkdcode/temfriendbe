package com.temfriend.backend.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ExceptionList {
    LOGIN_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "로그인에 실패하였습니다."),
    POST_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "게시글 작성에 실패하였습니다."),
    POST_REPLY_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "댓글 작성에 실패하였습니다."),
    LIKE_FAILE_EXCEPTION(HttpStatus.BAD_REQUEST, "좋아요에 실패하였습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;
}
