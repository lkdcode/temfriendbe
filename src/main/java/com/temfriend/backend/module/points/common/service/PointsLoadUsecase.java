package com.temfriend.backend.module.points.common.service;

import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.points.domain.Points;

public interface PointsLoadUsecase {
    Points loadPointsFromUsers(Users users);
}
