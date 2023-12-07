package com.temfriend.backend.module.points.command;

import com.temfriend.backend.module.users.domain.Users;

public interface PointsCommandUsecase {
    void executeCreatePointsByUsers(Users users);

    void executeIncrementPointsFromCreatePosts(Users users);

    void executeIncrementPointsFromLogIn(Users users);
}
