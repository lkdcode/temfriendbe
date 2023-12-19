package com.temfriend.backend.module.points.common.service;

import com.temfriend.backend.module.points.domain.Points;
import com.temfriend.backend.module.points.domain.repository.PointsRepository;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PointsSaveService {
    private final PointsRepository pointsRepository;

    public void save(Users users) {
        pointsRepository.save(Points.newInstance(users));
    }
}
