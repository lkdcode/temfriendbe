package com.temfriend.backend.module.posts.command.service;

import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.posts.command.dto.request.PostsRequestDTO;
import com.temfriend.backend.module.posts.command.dto.response.PostsResponseDTO;

public interface PostsCommandUsecase {
    PostsResponseDTO.Create executePostsSave(PostsRequestDTO.Create request, CustomUsersDetail customUsersDetail);

    PostsResponseDTO.Update executePostsUpdate(PostsRequestDTO.Update request, CustomUsersDetail customUsersDetail, Long postsId);

    PostsResponseDTO.Update executePostsUpdate(PostsRequestDTO.UpdateOnlyTitle request, CustomUsersDetail customUsersDetail, Long postsId);

    PostsResponseDTO.Update executePostsUpdate(PostsRequestDTO.UpdateOnlyContent request, CustomUsersDetail customUsersDetail, Long postsId);

    PostsResponseDTO.Delete executePostsDelete(Long id, CustomUsersDetail customUsersDetail);

}
