package com.temfriend.backend.module.posts.global.service;

import com.temfriend.backend.module.posts.global.exception.custom.PostsAccessDeniedException;
import com.temfriend.backend.module.posts.global.exception.enums.PostsErrorCode;
import com.temfriend.backend.module.posts.domain.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostsValidator {

    public void validateAuthorship(Posts posts, Long usersId) throws PostsAccessDeniedException {
        if (!posts.getId().equals(usersId)) {
            throw new PostsAccessDeniedException(PostsErrorCode.NOT_MATCHES);
        }
    }
}
