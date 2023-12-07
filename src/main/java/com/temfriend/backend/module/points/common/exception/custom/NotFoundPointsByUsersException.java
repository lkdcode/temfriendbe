package com.temfriend.backend.module.points.common.exception.custom;

import com.temfriend.backend.global.exception.custom.AppException;
import com.temfriend.backend.global.exception.custom.ExceptionCode;

public class NotFoundPointsByUsersException extends AppException {
    public NotFoundPointsByUsersException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
