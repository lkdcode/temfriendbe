package com.temfriend.backend.modules.post.exception;

import com.temfriend.backend.global.exception.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum PostCreateExceptionList implements ExceptionCode {
    POST_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "게시글 작성에 실패하였습니다."),
    POST_UPDATE_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "게시글 수정에 실패하였습니다."),
    POST_DELETE_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "게시글 삭제에 실패하였습니다."),
    POST_REPLY_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "댓글 작성에 실패하였습니다."),
    LIKE_FAILE_EXCEPTION(HttpStatus.BAD_REQUEST, "좋아요에 실패하였습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;
}
