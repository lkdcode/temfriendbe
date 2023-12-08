package com.temfriend.backend.module.activities.exception.custom;

import com.temfriend.backend.global.common.exception.custom.AppException;
import com.temfriend.backend.global.common.exception.custom.ExceptionCode;

public class NotFoundActivitiesByUsersException extends AppException {
    public NotFoundActivitiesByUsersException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
