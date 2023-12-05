package com.temfriend.backend.module.posts.query.service;

import com.temfriend.backend.module.posts.query.dto.response.PostsQueryResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostsQueryUsecase {

    PostsQueryResponseDTO.Get retrieveSinglePostsById(Long postsId);

    List<PostsQueryResponseDTO.Get> retrievePostsList(Pageable pageable);

    List<PostsQueryResponseDTO.Get> retrievePostsListByUsersId(Long usersId);
}
