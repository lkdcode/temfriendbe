package com.temfriend.backend.modules.post.service.post.impl;

import com.temfriend.backend.modules.post.domain.Post;
import com.temfriend.backend.modules.post.domain.repository.PostRepository;
import com.temfriend.backend.modules.post.service.post.PostCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostingCreateService implements PostCreateService {
    private final PostRepository postRepository;

    @Override
    public boolean create(Post post) {
        try {
            Post save = postRepository.save(post);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException("글 작성 실패");
        }
    }
}
