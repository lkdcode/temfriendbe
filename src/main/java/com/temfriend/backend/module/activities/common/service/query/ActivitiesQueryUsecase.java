package com.temfriend.backend.module.activities.common.service.query;

import com.temfriend.backend.module.users.domain.Users;

public interface ActivitiesQueryUsecase {
    boolean canRecordLoginCreationTime(Users users);

    boolean canRecordPostCreationTime(Users users);
}
