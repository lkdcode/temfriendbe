package com.temfriend.backend.module.User.domain.repository;

import com.temfriend.backend.module.User.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
