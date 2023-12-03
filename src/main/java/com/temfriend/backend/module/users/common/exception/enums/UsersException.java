package com.temfriend.backend.module.users.common.exception.enums;

import com.temfriend.backend.global.exception.custom.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UsersException implements ExceptionCode {
    NOT_FOUNT_USERS_FROM_EMAIL(HttpStatus.NOT_FOUND, "해당 이메일의 유저는 존재하지 않습니다."),
    NOT_FOUNT_USERS_FROM_NICKNAME(HttpStatus.NOT_FOUND, "해당 닉네임의 유저는 존재하지 않습니다."),
    LOGIN_FAIL_INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "아이디 혹은 비밀번호가 틀렸습니다."),
    DUPLICATE_USERS_EMAIL(HttpStatus.CONFLICT, "이미 존재하는 이메일입니다."),
    DUPLICATE_USERS_NICKNAME(HttpStatus.CONFLICT, "이미 존재하는 닉네임입니다."),
    SIGNUP_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "회원가입에 실패했습니다."),
    SIGNIN_FAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "로그인에 실패했습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;

}
