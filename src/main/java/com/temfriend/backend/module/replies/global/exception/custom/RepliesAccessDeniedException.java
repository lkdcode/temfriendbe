package com.temfriend.backend.module.replies.global.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class RepliesAccessDeniedException extends CustomException {
    public RepliesAccessDeniedException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
