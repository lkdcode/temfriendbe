package com.temfriend.backend.module.replies.domain.repository;

import com.temfriend.backend.module.replies.domain.Replies;
import com.temfriend.backend.module.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepliesRepository extends JpaRepository<Replies, Long> {
    Optional<Replies> findByUsers(Users users);

    List<Replies> findByPostsId(Long postsId);
}
