package com.temfriend.backend.global.common.exception.custom;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    HttpStatus getHttpStatus();

    String getMessage();

    String getCode();
}
