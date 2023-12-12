package com.temfriend.backend.module.replies.global.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class NotFoundRepliesByIdException extends CustomException {
    public NotFoundRepliesByIdException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
