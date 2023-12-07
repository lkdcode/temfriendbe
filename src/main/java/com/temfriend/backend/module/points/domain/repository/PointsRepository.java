package com.temfriend.backend.module.points.domain.repository;

import com.temfriend.backend.module.points.domain.Points;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointsRepository extends JpaRepository<Points, Long> {
    Optional<Points> findByUsersId(Long usersId);
}
