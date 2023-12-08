package com.temfriend.backend.global.common.exception.custom;

import org.springframework.http.HttpStatus;

public interface ExceptionCode {

    HttpStatus getHttpStatus();

    String getMessage();

}
