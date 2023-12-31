package com.temfriend.backend.module.users.common.exception.error;

import com.temfriend.backend.global.common.exception.custom.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UsersErrorCode implements ErrorCode {
    NOT_FOUNT_USERS_FROM_EMAIL("USERS-001", HttpStatus.NOT_FOUND, "해당 이메일의 유저는 존재하지 않습니다."),
    NOT_FOUNT_USERS_FROM_NICKNAME("USERS-002", HttpStatus.NOT_FOUND, "해당 닉네임의 유저는 존재하지 않습니다."),
    LOGIN_FAIL_INVALID_CREDENTIALS("USERS-003", HttpStatus.UNAUTHORIZED, "아이디 혹은 비밀번호가 틀렸습니다."),
    PASSWORD_MISMATCH_ERROR("USERS-004", HttpStatus.BAD_REQUEST, "첫 번째 비밀번호와 두 번째 비밀번호가 다릅니다."),
    DUPLICATE_USERS_EMAIL("USERS-005", HttpStatus.CONFLICT, "이미 존재하는 이메일입니다."),
    DUPLICATE_USERS_NICKNAME("USERS-006", HttpStatus.CONFLICT, "이미 존재하는 닉네임입니다."),
    SIGNUP_FAIL_EXCEPTION("USERS-007", HttpStatus.BAD_REQUEST, "회원가입에 실패했습니다."),
    SIGNIN_FAIL_EXCEPTION("USERS-008", HttpStatus.BAD_REQUEST, "로그인에 실패했습니다."),
    ;
    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}
