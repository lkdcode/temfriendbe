package com.temfriend.backend.module.activities.service.command;

import com.temfriend.backend.module.users.domain.Users;

public interface ActivitiesCommandUsecase {
    void executeUpdatePostsCreateTime(Users users);

    void executeUpdateLoginTime(Users users);
}