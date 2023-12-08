package com.temfriend.backend.global.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.temfriend.backend.global.common.exception.custom.CustomException;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@JsonPropertyOrder({"code", "httpStatus", "message"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final String code;
    private final HttpStatus httpStatus;
    private final String message;

    @Builder
    private ErrorResponse(String code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public static ErrorResponse fail(CustomException appException) {
        return ErrorResponse.builder()
                .code(appException.getCode())
                .httpStatus(appException.getHttpStatus())
                .message(appException.getMessage())
                .build();
    }
}
