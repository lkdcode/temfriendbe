package com.temfriend.backend.module.activities.exception.enums;

import com.temfriend.backend.global.common.exception.custom.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ActivitiesException implements ExceptionCode {
    NOT_FOUNT_ACTIVITIES_FROM_USERS(HttpStatus.NOT_FOUND, "해당 유저의 활동 내역은 존재하지 않습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;

}
