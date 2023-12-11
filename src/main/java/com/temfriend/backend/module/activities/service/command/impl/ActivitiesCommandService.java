package com.temfriend.backend.module.activities.service.command.impl;

import com.temfriend.backend.module.activities.domain.Activities;
import com.temfriend.backend.module.activities.service.ActivitiesLoadService;
import com.temfriend.backend.module.activities.service.command.ActivitiesCommandUsecase;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ActivitiesCommandService implements ActivitiesCommandUsecase {
    private final ActivitiesLoadService activitiesLoadService;

    @Override
    public void executeUpdateLoginTime(Users users) {
        Activities histories = activitiesLoadService.loadActivitiesByUsers(users);
        histories.recordLoginTime();
    }

    @Override
    public void executeUpdatePostsCreateTime(Users users) {
        Activities histories = activitiesLoadService.loadActivitiesByUsers(users);
        histories.recordPostsCreationTime();
    }
}
