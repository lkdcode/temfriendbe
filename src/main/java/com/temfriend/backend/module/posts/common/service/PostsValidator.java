package com.temfriend.backend.module.posts.common.service;

import com.temfriend.backend.module.posts.domain.repository.PostsRepository;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostsValidator {
    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    public void validateAuthorship(Long postsId, Long usersId) {
        postsRepository.findById(postsId);
    }

}
