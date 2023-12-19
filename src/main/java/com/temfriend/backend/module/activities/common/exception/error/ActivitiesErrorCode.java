package com.temfriend.backend.module.activities.common.exception.error;

import com.temfriend.backend.global.common.exception.custom.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ActivitiesErrorCode implements ErrorCode {
    NOT_FOUNT_ACTIVITIES_FROM_USERS("ACTIVITIES-001", HttpStatus.NOT_FOUND, "해당 유저의 활동 내역은 존재하지 않습니다."),
    ;
    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}
