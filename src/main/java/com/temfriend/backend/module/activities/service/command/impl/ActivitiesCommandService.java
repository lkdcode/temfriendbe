package com.temfriend.backend.module.activities.service.command.impl;

import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.activities.domain.Activities;
import com.temfriend.backend.module.activities.service.ActivitiesLoadService;
import com.temfriend.backend.module.activities.service.command.ActivitiesCommandUsecase;
import com.temfriend.backend.module.users.common.service.UsersLoadService;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ActivitiesCommandService implements ActivitiesCommandUsecase {
    private final ActivitiesLoadService activitiesLoadService;
    private final UsersLoadService usersLoadService;

    @Override
    public void executeUpdateLoginTime(CustomUsersDetail customUsersDetail) {
        Activities histories = findActivitiesBy(customUsersDetail);
        histories.recordLoginTime();
    }

    @Override
    public void executeUpdatePostsCreateTime(CustomUsersDetail customUsersDetail) {
        Activities histories = findActivitiesBy(customUsersDetail);
        histories.recordPostsCreationTime();
    }

    private Activities findActivitiesBy(CustomUsersDetail customUsersDetail) {
        Users users = usersLoadService.loadUsersFromEmail(customUsersDetail.getEmail());
        return activitiesLoadService.loadActivitiesByUsers(users);
    }
}
