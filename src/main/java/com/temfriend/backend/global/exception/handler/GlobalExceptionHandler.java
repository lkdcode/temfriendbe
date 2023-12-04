package com.temfriend.backend.global.exception.handler;

import com.temfriend.backend.global.exception.custom.AppException;
import com.temfriend.backend.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleRuntimeException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();

        log.error("Valid. message : {}", message);

        return ResponseEntity
                .badRequest()
                .body(message);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
        String message = e.getMessage();
        log.error("RuntimeException. message : {}", message);

        return ResponseEntity
                .internalServerError()
                .body(message);
    }
}
