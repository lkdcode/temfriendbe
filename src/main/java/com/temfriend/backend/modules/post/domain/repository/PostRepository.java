package com.temfriend.backend.modules.post.domain.repository;

import com.temfriend.backend.modules.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
