package com.temfriend.backend.modules.member.exception;

import com.temfriend.backend.global.exception.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum MemberExceptionList implements ExceptionCode {
    SIGNUP_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "회원가입에 실패했습니다."),
    SIGNIN_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "로그인에 실패했습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;

}
