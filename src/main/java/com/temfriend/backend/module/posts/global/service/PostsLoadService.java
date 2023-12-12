package com.temfriend.backend.module.posts.global.service;

import com.temfriend.backend.module.posts.global.exception.custom.NotFoundPostsByIdException;
import com.temfriend.backend.module.posts.global.exception.enums.PostsErrorCode;
import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.posts.domain.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostsLoadService {
    private final PostsRepository postsRepository;

    public Posts loadPostsFromId(Long id) throws NotFoundPostsByIdException {
        return postsRepository.findById(id).orElseThrow(() ->
                new NotFoundPostsByIdException(PostsErrorCode.NOT_FOUNT_POSTS_FROM_ID));
    }

    public List<Posts> loadPostsList(Pageable pageable) {
        Page<Posts> postsPage = postsRepository.findAll(pageable);
        return postsPage.getContent();
    }

    public List<Posts> loadPostsListByUsersId(Long usersId) {
        return postsRepository.findAllByUsersId(usersId);
    }
}
