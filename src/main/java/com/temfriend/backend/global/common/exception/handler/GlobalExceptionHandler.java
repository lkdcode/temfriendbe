package com.temfriend.backend.global.common.exception.handler;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("[AppException] ErrorCode : {}, ErrorHttpStatus : {}, ErrorMessage : {}", e.getCode(), e.getHttpStatus(), e.getMessage());

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

        log.error("[Valid] ErrorMessage : {}", message);

        return ResponseEntity
                .badRequest()
                .body(message);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String message = e.getMessage();
        assert message != null;

        message = message.substring(message.indexOf("<") + 1, message.indexOf(">"));

        log.error("[HttpMessageNotReadableException] ErrorMessage : {}", message);

        return ResponseEntity
                .badRequest()
                .body("누락된 본문 요청 : " + message);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
        String message = e.getMessage();
        log.error("[RuntimeException] ErrorMessage : {}", message);

        return ResponseEntity
                .internalServerError()
                .body(message);
    }
}
