package com.temfriend.backend.module.posts.query.service.impl;

import com.temfriend.backend.module.posts.common.service.PostsLoadService;
import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.posts.query.dto.response.PostsQueryResponseDTO;
import com.temfriend.backend.module.posts.query.mapper.response.PostsQueryMapper;
import com.temfriend.backend.module.posts.query.service.PostsQueryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostsQueryService implements PostsQueryUsecase {
    private final PostsLoadService postsLoadService;

    @Override
    public PostsQueryResponseDTO.Get retrieveSinglePostsById(Long id) {
        Posts posts = postsLoadService.loadPostsFromId(id);

        return PostsQueryMapper.INSTANCE
                .convertGetFrom(posts);
    }

    @Override
    public List<PostsQueryResponseDTO.Get> retrievePostsList(Pageable pageable) {
        List<Posts> postsList = postsLoadService.loadPostsList(pageable);

        return getListResponseGetFrom(postsList);
    }

    @Override
    public List<PostsQueryResponseDTO.Get> retrievePostsListByUsersId(Long usersId) {
        List<Posts> postsList = postsLoadService.loadPostsListByUsersId(usersId);

        return getListResponseGetFrom(postsList);
    }

    private List<PostsQueryResponseDTO.Get> getListResponseGetFrom(List<Posts> postsList) {
        return PostsQueryMapper.INSTANCE
                .convertGetListFrom(postsList);
    }
}
