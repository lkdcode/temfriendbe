package com.temfriend.backend.module.activities.command;

import com.temfriend.backend.module.users.domain.Users;

public interface ActivitiesCommandUsecase {
    void executeUpdatePostsCreateTime(Users users);

    void executeUpdateLoginTime(Users users);

    void save(Users users);
}