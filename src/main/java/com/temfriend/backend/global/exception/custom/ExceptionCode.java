package com.temfriend.backend.global.exception.custom;

import org.springframework.http.HttpStatus;

public interface ExceptionCode {

    HttpStatus getHttpStatus();

    String getMessage();

}
