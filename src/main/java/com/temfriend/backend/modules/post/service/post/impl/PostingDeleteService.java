package com.temfriend.backend.modules.post.service.post.impl;

import com.temfriend.backend.modules.post.domain.Post;
import com.temfriend.backend.modules.post.domain.repository.PostRepository;
import com.temfriend.backend.modules.post.service.post.PostDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostingDeleteService implements PostDeleteService {

    private final PostRepository postRepository;

    @Override
    public boolean delete(Post post) {
        try {
            postRepository.delete(post);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException("삭제 실패.");
        }
    }
}
