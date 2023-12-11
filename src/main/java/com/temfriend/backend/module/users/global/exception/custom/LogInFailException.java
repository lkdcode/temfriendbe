package com.temfriend.backend.module.users.global.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class LogInFailException extends CustomException {
    public LogInFailException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
