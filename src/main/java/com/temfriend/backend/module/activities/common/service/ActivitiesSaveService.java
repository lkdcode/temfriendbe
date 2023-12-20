package com.temfriend.backend.module.activities.common.service;

import com.temfriend.backend.module.activities.domain.Activities;
import com.temfriend.backend.module.activities.domain.repository.ActivitiesRepository;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ActivitiesSaveService {
    private final ActivitiesRepository activitiesRepository;

    public void save(Users users) {
        activitiesRepository.save(Activities.builder()
                .users(users)
                .build());
    }
}
