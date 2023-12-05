package com.temfriend.backend.module.posts.command.service;

import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.posts.command.dto.request.PostsCommandRequestDTO;
import com.temfriend.backend.module.posts.command.dto.response.PostsCommandResponseDTO;

public interface PostsCommandUsecase {
    PostsCommandResponseDTO.Create executePostsSave(PostsCommandRequestDTO.Create request, CustomUsersDetail customUsersDetail);

    PostsCommandResponseDTO.Update executePostsUpdate(PostsCommandRequestDTO.Update request, CustomUsersDetail customUsersDetail, Long postsId);

    PostsCommandResponseDTO.Delete executePostsDelete(Long id, CustomUsersDetail customUsersDetail);

}
