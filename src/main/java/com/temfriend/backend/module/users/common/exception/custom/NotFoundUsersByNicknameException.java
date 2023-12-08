package com.temfriend.backend.module.users.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.AppException;
import com.temfriend.backend.global.common.exception.custom.ExceptionCode;

public class NotFoundUsersByNicknameException extends AppException {
    public NotFoundUsersByNicknameException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
