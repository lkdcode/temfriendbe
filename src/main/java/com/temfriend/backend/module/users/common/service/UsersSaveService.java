package com.temfriend.backend.module.users.common.service;

import com.temfriend.backend.module.activities.common.service.ActivitiesSaveService;
import com.temfriend.backend.module.points.common.service.PointsSaveService;
import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersSaveService {
    private final UsersRepository usersRepository;
    private final PointsSaveService pointsSaveService;
    private final ActivitiesSaveService activitiesSaveService;

    public void save(Users users) {
        Users saved = usersRepository.save(users);
        pointsSaveService.save(saved);
        activitiesSaveService.save(saved);
    }
}
