package com.temfriend.backend.module.activities.common.exception.custom;

import com.temfriend.backend.global.common.exception.custom.CustomException;
import com.temfriend.backend.global.common.exception.custom.ErrorCode;

public class NotFoundActivitiesByUsersException extends CustomException {
    public NotFoundActivitiesByUsersException(ErrorCode exceptionCode) {
        super(exceptionCode);
    }
}
