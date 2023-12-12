package com.temfriend.backend.module.posts.global.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class PostsAccessDeniedException extends CustomException {
    public PostsAccessDeniedException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
