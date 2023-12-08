package com.temfriend.backend.module.posts.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class NotFoundPostsByIdException extends CustomException {
    public NotFoundPostsByIdException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
