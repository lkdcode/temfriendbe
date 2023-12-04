package com.temfriend.backend.module.users.domain.repository;

import com.temfriend.backend.module.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByProfile_Nickname(String nickname);
}
