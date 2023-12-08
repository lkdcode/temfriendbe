package com.temfriend.backend.module.users.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class NotFoundUsersByNicknameException extends CustomException {
    public NotFoundUsersByNicknameException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
