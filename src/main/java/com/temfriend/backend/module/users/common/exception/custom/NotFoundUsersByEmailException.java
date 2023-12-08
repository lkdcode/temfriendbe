package com.temfriend.backend.module.users.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class NotFoundUsersByEmailException extends CustomException {
    public NotFoundUsersByEmailException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
