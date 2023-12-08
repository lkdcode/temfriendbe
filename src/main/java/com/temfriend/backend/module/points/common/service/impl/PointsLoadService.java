package com.temfriend.backend.module.points.common.service.impl;

import com.temfriend.backend.module.points.common.exception.error.PointsErrorCode;
import com.temfriend.backend.module.points.common.service.PointsLoadUsecase;
import com.temfriend.backend.module.posts.common.exception.custom.NotFoundPostsByIdException;
import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.points.domain.Points;
import com.temfriend.backend.module.points.domain.repository.PointsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PointsLoadService implements PointsLoadUsecase {
    private final PointsRepository pointsRepository;

    @Override
    public Points loadPointsFromUsers(Users users) {
        return pointsRepository.findByUsersId(users.getId())
                .orElseThrow(() -> new NotFoundPostsByIdException(PointsErrorCode.NOT_FOUNT_POINTS_BY_USERS));
    }
}
