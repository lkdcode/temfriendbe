package com.temfriend.backend.module.points.command.impl;

import com.temfriend.backend.module.points.command.PointsCommandUsecase;
import com.temfriend.backend.module.points.common.service.PointsLoadUsecase;
import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.points.domain.Points;
import com.temfriend.backend.module.points.domain.repository.PointsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PointsCommandService implements PointsCommandUsecase {
    private final PointsLoadUsecase pointsLoadUsecase;
    private final PointsRepository pointsRepository;

    @Override
    public void executeCreatePointsByUsers(Users users) {
        pointsRepository.save(Points.newInstance(users));
    }

    @Override
    public void executeIncrementPointsFromCreatePosts(Users users) {
        Points points = pointsLoadUsecase.loadPointsFromUsers(users);
        points.addPostsCreateScore();
    }

    @Override
    public void executeIncrementPointsFromLogIn(Users users) {
        Points points = pointsLoadUsecase.loadPointsFromUsers(users);
        points.addLogInScore();
    }
}