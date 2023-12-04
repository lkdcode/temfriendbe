package com.temfriend.backend.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonPropertyOrder({"message", "payload"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse<T> {
    private static final String SUCCESS_MESSAGE = "요청을 성공적으로 불러왔습니다.";
    private final String message;
    private final T payload;

    public static <T> SuccessResponse<T> ok(T payload) {
        return new SuccessResponse<>(SUCCESS_MESSAGE, payload);
    }
}