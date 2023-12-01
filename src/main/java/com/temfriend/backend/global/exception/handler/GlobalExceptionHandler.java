package com.temfriend.backend.global.exception.handler;

import com.temfriend.backend.global.exception.custom.AppException;
import com.temfriend.backend.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException e) {
        log.error("AppException. message : {} , httpStatus : {}" + e.getMessage(), e.getHttpStatus());

        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ErrorResponse.fail(e));
    }
}
