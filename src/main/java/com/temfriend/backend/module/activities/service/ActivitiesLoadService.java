package com.temfriend.backend.module.activities.service;

import com.temfriend.backend.module.activities.domain.Activities;
import com.temfriend.backend.module.activities.domain.repository.ActivitiesRepository;
import com.temfriend.backend.module.activities.exception.custom.NotFoundActivitiesByUsersException;
import com.temfriend.backend.module.activities.exception.enums.ActivitiesException;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ActivitiesLoadService {
    private final ActivitiesRepository historiesRepository;

    public Activities loadActivitiesByUsers(Users users) {
        return historiesRepository.findByUsers(users)
                .orElseThrow(() -> new NotFoundActivitiesByUsersException(ActivitiesException.NOT_FOUNT_ACTIVITIES_FROM_USERS));
    }
}
