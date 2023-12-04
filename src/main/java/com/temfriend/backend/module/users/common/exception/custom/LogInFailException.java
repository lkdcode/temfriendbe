package com.temfriend.backend.module.users.common.exception.custom;

import com.temfriend.backend.global.exception.custom.AppException;
import com.temfriend.backend.global.exception.custom.ExceptionCode;

public class LogInFailException extends AppException {
    public LogInFailException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
