package com.temfriend.backend.module.posts.command.service.impl;

import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.posts.command.dto.request.PostsRequestDTO;
import com.temfriend.backend.module.posts.command.dto.response.PostsResponseDTO;
import com.temfriend.backend.module.posts.command.mapper.request.PostsRequestMapper;
import com.temfriend.backend.module.posts.command.service.PostsCommandUsecase;
import com.temfriend.backend.module.posts.common.service.PostsLoadService;
import com.temfriend.backend.module.posts.common.service.PostsValidator;
import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.posts.domain.repository.PostsRepository;
import com.temfriend.backend.module.users.common.service.UsersLoadService;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class PostsCommandService implements PostsCommandUsecase {
    private final PostsLoadService postsLoadService;
    private final PostsValidator postsValidator;
    private final PostsRepository postsRepository;
    private final UsersLoadService usersLoadService;

    @Override
    public PostsResponseDTO.Create executePostsSave(
            PostsRequestDTO.Create request
            , CustomUsersDetail customUsersDetail
    ) {
        Users users = usersLoadService.loadUsersFromEmail(customUsersDetail.getEmail());
        Posts posts = PostsRequestMapper.INSTANCE.createDTOToPosts(request, users);

        Posts saved = postsRepository.save(posts);

        return PostsResponseDTO.Create.builder()
                .id(saved.getId())
                .message("게시글 작성에 성공했습니다.")
                .build();
    }

    @Override
    public PostsResponseDTO.Update executePostsUpdate(
            PostsRequestDTO.Update request
            , CustomUsersDetail customUsersDetail
            , Long postsId
    ) {
        postsValidator.validateAuthorship(postsId, customUsersDetail.getId());

        Posts posts = postsLoadService.loadPostsFromId(postsId);
        posts.update(request.title(), request.content());

        return PostsResponseDTO.Update.builder()
                .id(posts.getId())
                .message("업데이트에 성공했습니다.")
                .build();
    }

    @Override
    public PostsResponseDTO.Update executePostsUpdate(
            PostsRequestDTO.UpdateOnlyTitle request
            , CustomUsersDetail customUsersDetail
            , Long postsId
    ) {
        postsValidator.validateAuthorship(postsId, customUsersDetail.getId());

        Posts posts = postsLoadService.loadPostsFromId(postsId);
        posts.update(request.title(), null);

        return PostsResponseDTO.Update.builder()
                .id(posts.getId())
                .message("업데이트에 성공했습니다.")
                .build();
    }

    @Override
    public PostsResponseDTO.Update executePostsUpdate(
            PostsRequestDTO.UpdateOnlyContent request
            , CustomUsersDetail customUsersDetail
            , Long postsId
    ) {
        postsValidator.validateAuthorship(postsId, customUsersDetail.getId());

        Posts posts = postsLoadService.loadPostsFromId(postsId);
        posts.update(null, request.content());

        return PostsResponseDTO.Update.builder()
                .id(posts.getId())
                .message("업데이트에 성공했습니다.")
                .build();
    }

    @Override
    public PostsResponseDTO.Delete executePostsDelete(
            Long id
            , CustomUsersDetail customUsersDetail
    ) {
        postsRepository.deleteById(id);

        return PostsResponseDTO.Delete.builder()
                .id(id)
                .message("삭제에 성공했습니다.")
                .build();
    }
}