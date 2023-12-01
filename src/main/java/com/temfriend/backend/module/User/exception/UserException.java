package com.temfriend.backend.module.User.exception;

import com.temfriend.backend.global.exception.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserException implements ExceptionCode {
    SIGNUP_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "회원가입에 실패했습니다."),
    SIGNIN_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "로그인에 실패했습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;

}
