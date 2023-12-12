package com.temfriend.backend.module.activities.service.query;

import com.temfriend.backend.module.users.domain.Users;

public interface ActivitiesQueryUsecase {
    boolean canRecordLoginCreationTime(Users users);

    boolean canRecordPostCreationTime(Users users);
}
