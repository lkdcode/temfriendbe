package com.temfriend.backend.module.replies.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.AppException;
import com.temfriend.backend.global.common.exception.custom.ExceptionCode;

public class NotFoundRepliesByIdException extends AppException {
    public NotFoundRepliesByIdException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
