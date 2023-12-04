package com.temfriend.backend.global.exception.custom;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;

    public AppException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.message = exceptionCode.getMessage();
        this.httpStatus = exceptionCode.getHttpStatus();
    }
}
