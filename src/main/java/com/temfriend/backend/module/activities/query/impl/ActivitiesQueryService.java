package com.temfriend.backend.module.activities.query.impl;

import com.temfriend.backend.module.activities.common.service.ActivitiesLoadService;
import com.temfriend.backend.module.activities.domain.Activities;
import com.temfriend.backend.module.activities.query.ActivitiesQueryUsecase;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ActivitiesQueryService implements ActivitiesQueryUsecase {
    private final ActivitiesLoadService activitiesLoadService;

    @Override
    public boolean canRecordLoginCreationTime(Users users) {
        Activities activities = activitiesLoadService.loadActivitiesByUsers(users);
        return activities.canRecordLoginCreationTime();
    }

    @Override
    public boolean canRecordPostCreationTime(Users users) {
        Activities activities = activitiesLoadService.loadActivitiesByUsers(users);
        return activities.canRecordPostCreationTime();
    }
}
