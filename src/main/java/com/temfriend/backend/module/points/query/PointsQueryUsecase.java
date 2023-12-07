package com.temfriend.backend.module.points.query;

import com.temfriend.backend.module.points.domain.Points;
import com.temfriend.backend.module.users.domain.Users;

public interface PointsQueryUsecase {
    Points retrievePointsByUsersId(Users users);
}
