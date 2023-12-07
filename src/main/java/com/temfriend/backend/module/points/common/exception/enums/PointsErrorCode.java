package com.temfriend.backend.module.points.common.exception.enums;

import com.temfriend.backend.global.exception.custom.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PointsErrorCode implements ExceptionCode {
    NOT_FOUNT_POINTS_BY_USERS(HttpStatus.NOT_FOUND, "해당 유저의 포인트 점수는 존재하지 않습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;

}
