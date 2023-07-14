package com.temfriend.backend.modules.post.domain.repository;

import com.temfriend.backend.modules.post.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
