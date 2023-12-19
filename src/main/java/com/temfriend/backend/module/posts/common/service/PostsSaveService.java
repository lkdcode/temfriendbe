package com.temfriend.backend.module.posts.common.service;

import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.posts.domain.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostsSaveService {
    private final PostsRepository postsRepository;

    public Posts save(Posts posts) {
        return postsRepository.save(posts);
    }
}
