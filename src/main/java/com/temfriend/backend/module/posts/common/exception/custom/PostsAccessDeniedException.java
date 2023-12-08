package com.temfriend.backend.module.posts.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.AppException;
import com.temfriend.backend.global.common.exception.custom.ExceptionCode;

public class PostsAccessDeniedException extends AppException {
    public PostsAccessDeniedException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
