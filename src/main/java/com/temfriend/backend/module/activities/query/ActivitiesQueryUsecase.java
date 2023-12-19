package com.temfriend.backend.module.activities.query;

import com.temfriend.backend.module.users.domain.Users;

public interface ActivitiesQueryUsecase {
    boolean canRecordLoginCreationTime(Users users);

    boolean canRecordPostCreationTime(Users users);
}
