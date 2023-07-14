package com.temfriend.backend.modules.post.domain.repository;

import com.temfriend.backend.modules.post.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostReplyRepository extends JpaRepository<Reply, Long> {
}
