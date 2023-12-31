package com.temfriend.backend.module.points.command.impl;

import com.temfriend.backend.module.activities.command.ActivitiesCommandUsecase;
import com.temfriend.backend.module.activities.query.ActivitiesQueryUsecase;
import com.temfriend.backend.module.points.command.PointsCommandUsecase;
import com.temfriend.backend.module.points.common.service.PointsLoadService;
import com.temfriend.backend.module.points.domain.Points;
import com.temfriend.backend.module.points.domain.repository.PointsRepository;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PointsCommandService implements PointsCommandUsecase {
    private final PointsLoadService pointsLoadService;
    private final PointsRepository pointsRepository;
    private final ActivitiesCommandUsecase activitiesCommandUsecase;
    private final ActivitiesQueryUsecase activitiesQueryUsecase;

    @Override
    public void executeCreatePointsByUsers(Users users) {
        pointsRepository.save(Points.newInstance(users));
        activitiesCommandUsecase.save(users);
    }

    @Override
    public void executeIncrementPointsFromLogIn(Users users) {
        boolean canRecordLoginCreationTime = activitiesQueryUsecase.canRecordLoginCreationTime(users);

        if (canRecordLoginCreationTime) {
            activitiesCommandUsecase.executeUpdateLoginTime(users);

            Points points = pointsLoadService.loadPointsFromUsers(users);
            points.addLogInScore();
        }
    }

    @Override
    public void executeIncrementPointsFromCreatePosts(Users users) {
        boolean canRecordPostCreationTime = activitiesQueryUsecase.canRecordPostCreationTime(users);

        if (canRecordPostCreationTime) {
            activitiesCommandUsecase.executeUpdatePostsCreateTime(users);

            Points points = pointsLoadService.loadPointsFromUsers(users);
            points.addPostsCreateScore();
        }
    }
}