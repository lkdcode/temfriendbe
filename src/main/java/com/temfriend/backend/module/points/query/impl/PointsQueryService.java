package com.temfriend.backend.module.points.query.impl;

import com.temfriend.backend.module.points.common.service.PointsLoadService;
import com.temfriend.backend.module.points.domain.Points;
import com.temfriend.backend.module.points.query.PointsQueryUsecase;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PointsQueryService implements PointsQueryUsecase {
    private final PointsLoadService pointsLoadService;

    @Override
    public Points retrievePointsByUsersId(Users users) {
        return pointsLoadService.loadPointsFromUsers(users);
    }
}
