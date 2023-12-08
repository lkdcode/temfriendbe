package com.temfriend.backend.module.replies.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class NotFoundRepliesByUsersException extends CustomException {
    public NotFoundRepliesByUsersException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
