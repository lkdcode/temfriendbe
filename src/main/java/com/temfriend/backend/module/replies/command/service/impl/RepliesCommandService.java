package com.temfriend.backend.module.replies.command.service.impl;

import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.posts.global.service.PostsLoadService;
import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.replies.command.dto.request.RepliesRequestDTO;
import com.temfriend.backend.module.replies.command.dto.response.RepliesResponseDTO;
import com.temfriend.backend.module.replies.command.mapper.request.RepliesRequestMapper;
import com.temfriend.backend.module.replies.command.mapper.response.RepliesResponseMapper;
import com.temfriend.backend.module.replies.command.service.RepliesCommandUsecase;
import com.temfriend.backend.module.replies.global.service.RepliesLoadService;
import com.temfriend.backend.module.replies.global.service.RepliesValidator;
import com.temfriend.backend.module.replies.domain.Replies;
import com.temfriend.backend.module.replies.domain.repository.RepliesRepository;
import com.temfriend.backend.module.users.global.service.UsersLoadService;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RepliesCommandService implements RepliesCommandUsecase {
    private static final String REPLIES_DELETE_SUCCESS_MESSAGE = "삭제된 댓글입니다.";
    private final RepliesRepository repliesRepository;
    private final UsersLoadService usersLoadService;
    private final PostsLoadService postsLoadService;
    private final RepliesLoadService repliesLoadService;
    private final RepliesValidator repliesValidator;

    @Override
    public RepliesResponseDTO.Create executeRepliesSave(
            Long postsId
            , RepliesRequestDTO.Create request
            , CustomUsersDetail customUsersDetail
    ) {
        Users users = usersLoadService.loadUsersFromEmail(customUsersDetail.getEmail());
        Posts posts = postsLoadService.loadPostsFromId(postsId);

        Replies replies = RepliesRequestMapper.INSTANCE.convertRepliesFrom(request, users, posts);
        Replies saved = repliesRepository.save(replies);

        return RepliesResponseMapper.INSTANCE
                .convertCreateDTOFrom(saved);
    }

    @Override
    public RepliesResponseDTO.Update executeRepliesUpdate(
            Long repliesId
            , RepliesRequestDTO.Update request
            , CustomUsersDetail customUsersDetail
    ) {
        Users users = usersLoadService.loadUsersFromEmail(customUsersDetail.getEmail());
        Replies replies = repliesLoadService.loadRepliesById(repliesId);

        repliesValidator.validateAuthorship(replies, users);

        replies.updateFor(request.content());

        return RepliesResponseMapper.INSTANCE
                .convertUpdateDTOFrom(replies);
    }

    @Override
    public RepliesResponseDTO.Delete executeRepliesDelete(
            Long repliesId
            , CustomUsersDetail customUsersDetail
    ) {
        Users users = usersLoadService.loadUsersFromEmail(customUsersDetail.getEmail());
        Replies replies = repliesLoadService.loadRepliesById(repliesId);

        repliesValidator.validateAuthorship(replies, users);

        replies.remove();

        return RepliesResponseDTO.Delete.builder()
                .content(REPLIES_DELETE_SUCCESS_MESSAGE)
                .build();
    }
}
