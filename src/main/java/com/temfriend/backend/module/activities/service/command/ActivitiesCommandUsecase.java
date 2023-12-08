package com.temfriend.backend.module.activities.service.command;

import com.temfriend.backend.global.security.CustomUsersDetail;

public interface ActivitiesCommandUsecase {
    void executeUpdateLoginTime(CustomUsersDetail customUsersDetail);

    void executeUpdatePostsCreateTime(CustomUsersDetail customUsersDetail);
}