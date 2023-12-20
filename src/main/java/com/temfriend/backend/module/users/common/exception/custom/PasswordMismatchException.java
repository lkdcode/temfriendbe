package com.temfriend.backend.module.users.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class PasswordMismatchException extends CustomException {
    public PasswordMismatchException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
