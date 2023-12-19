package com.temfriend.backend.module.points.common.exception.error;

import com.temfriend.backend.global.common.exception.custom.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PointsErrorCode implements ErrorCode {
    NOT_FOUNT_POINTS_BY_USERS("POINTS-001", HttpStatus.NOT_FOUND, "해당 유저의 포인트 점수는 존재하지 않습니다."),
    ;
    private final String code;
    private final HttpStatus httpStatus;
    private final String message;

}
