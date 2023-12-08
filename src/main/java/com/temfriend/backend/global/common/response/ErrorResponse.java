package com.temfriend.backend.global.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.temfriend.backend.global.common.exception.custom.AppException;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@JsonPropertyOrder({"message", "httpStatus"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final String message;
    private final HttpStatus httpStatus;

    @Builder
    private ErrorResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public static ErrorResponse fail(AppException appException) {
        return ErrorResponse.builder()
                .message(appException.getMessage())
                .httpStatus(appException.getHttpStatus())
                .build();
    }
}
