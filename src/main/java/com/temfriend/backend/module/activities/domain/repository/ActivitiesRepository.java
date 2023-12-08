package com.temfriend.backend.module.activities.domain.repository;

import com.temfriend.backend.module.activities.domain.Activities;
import com.temfriend.backend.module.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activities, Long> {
    Optional<Activities> findByUsers(Users users);
}
