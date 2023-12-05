package com.temfriend.backend.module.posts.domain.repository;

import com.temfriend.backend.module.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    List<Posts> findAllByUsersId(Long usersId);
}
