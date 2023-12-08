package com.temfriend.backend.module.replies.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.AppException;
import com.temfriend.backend.global.common.exception.custom.ExceptionCode;

public class NotFoundRepliesByUsersException extends AppException {
    public NotFoundRepliesByUsersException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
