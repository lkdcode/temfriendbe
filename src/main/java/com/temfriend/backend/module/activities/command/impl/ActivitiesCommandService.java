package com.temfriend.backend.module.activities.command.impl;

import com.temfriend.backend.module.activities.common.service.ActivitiesLoadService;
import com.temfriend.backend.module.activities.domain.Activities;
import com.temfriend.backend.module.activities.domain.repository.ActivitiesRepository;
import com.temfriend.backend.module.activities.command.ActivitiesCommandUsecase;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ActivitiesCommandService implements ActivitiesCommandUsecase {
    private final ActivitiesLoadService activitiesLoadService;
    private final ActivitiesRepository activitiesRepository;

    @Override
    public void executeUpdateLoginTime(Users users) {
        Activities histories = activitiesLoadService.loadActivitiesByUsers(users);
        histories.recordLoginTime();
    }

    @Override
    public void save(Users users) {
        activitiesRepository.save(Activities.builder()
                .users(users)
                .build());
    }

    @Override
    public void executeUpdatePostsCreateTime(Users users) {
        Activities histories = activitiesLoadService.loadActivitiesByUsers(users);
        histories.recordPostsCreationTime();
    }
}
