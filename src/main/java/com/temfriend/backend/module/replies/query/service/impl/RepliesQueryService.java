package com.temfriend.backend.module.replies.query.service.impl;

import com.temfriend.backend.module.replies.common.service.RepliesLoadService;
import com.temfriend.backend.module.replies.domain.Replies;
import com.temfriend.backend.module.replies.query.dto.response.RepliesQueryDTO;
import com.temfriend.backend.module.replies.query.mapper.RepliesQueryMapper;
import com.temfriend.backend.module.replies.query.service.RepliesQueryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RepliesQueryService implements RepliesQueryUsecase {
    private final RepliesLoadService repliesLoadService;

    @Override
    public List<RepliesQueryDTO.Get> retrieveRepliesListByPostsId(Long postsId) {
        List<Replies> repliesList = repliesLoadService.loadRepliesListByPostsId(postsId);
        return RepliesQueryMapper.INSTANCE.convertGetDTOListFrom(repliesList);
    }
}
