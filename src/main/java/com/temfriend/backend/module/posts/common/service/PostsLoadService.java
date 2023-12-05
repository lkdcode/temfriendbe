package com.temfriend.backend.module.posts.common.service;

import com.temfriend.backend.module.posts.common.exception.custom.NotFoundPostsByIdException;
import com.temfriend.backend.module.posts.common.exception.enums.PostsException;
import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.posts.domain.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostsLoadService {
    private final PostsRepository postsRepository;

    public Posts loadPostsFromId(Long id) {
        return postsRepository.findById(id).orElseThrow(() ->
                new NotFoundPostsByIdException(PostsException.NOT_FOUNT_POSTS_FROM_ID));
    }
}
