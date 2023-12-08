package com.temfriend.backend.module.points.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class NotFoundPointsByUsersException extends CustomException {
    public NotFoundPointsByUsersException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
