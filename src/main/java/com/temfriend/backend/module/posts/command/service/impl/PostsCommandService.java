package com.temfriend.backend.module.posts.command.service.impl;

import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.posts.command.dto.request.PostsCommandRequestDTO;
import com.temfriend.backend.module.posts.command.dto.response.PostsCommandResponseDTO;
import com.temfriend.backend.module.posts.command.mapper.request.PostsRequestMapper;
import com.temfriend.backend.module.posts.command.service.PostsCommandUsecase;
import com.temfriend.backend.module.posts.common.service.PostsLoadService;
import com.temfriend.backend.module.posts.common.service.PostsValidator;
import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.posts.domain.repository.PostsRepository;
import com.temfriend.backend.module.users.common.service.UsersLoadService;
import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.points.command.PointsCommandUsecase;
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
    private final PointsCommandUsecase pointsCommandUsecase;

    @Override
    public PostsCommandResponseDTO.Create executePostsSave(
            PostsCommandRequestDTO.Create request
            , CustomUsersDetail customUsersDetail
    ) {
        Users users = usersLoadService.loadUsersFromEmail(customUsersDetail.getEmail());
        Posts posts = PostsRequestMapper.INSTANCE.convertPostsFrom(request, users);

        Posts saved = postsRepository.save(posts);
        pointsCommandUsecase.executeIncrementPointsFromCreatePosts(users);

        return PostsCommandResponseDTO.Create.builder()
                .id(saved.getId())
                .message("게시글 작성에 성공했습니다.")
                .build();
    }

    @Override
    public PostsCommandResponseDTO.Update executePostsUpdate(
            PostsCommandRequestDTO.Update request
            , CustomUsersDetail customUsersDetail
            , Long postsId
    ) {
        Posts posts = postsLoadService.loadPostsFromId(postsId);

        postsValidator.validateAuthorship(posts, customUsersDetail.getId());
        posts.update(request.title(), request.content());

        return PostsCommandResponseDTO.Update.builder()
                .id(posts.getId())
                .message("업데이트에 성공했습니다.")
                .build();
    }

    @Override
    public PostsCommandResponseDTO.Delete executePostsDelete(
            Long id
            , CustomUsersDetail customUsersDetail
    ) {
        Posts posts = postsLoadService.loadPostsFromId(id);

        postsValidator.validateAuthorship(posts, customUsersDetail.getId());
        posts.remove();

        return PostsCommandResponseDTO.Delete.builder()
                .id(id)
                .message("삭제에 성공했습니다.")
                .build();
    }
}
