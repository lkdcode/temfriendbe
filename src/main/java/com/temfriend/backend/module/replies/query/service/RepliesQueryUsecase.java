package com.temfriend.backend.module.replies.query.service;

import com.temfriend.backend.module.replies.query.dto.response.RepliesQueryDTO;

import java.util.List;

public interface RepliesQueryUsecase {
    List<RepliesQueryDTO.Get> retrieveRepliesListByPostsId(Long postsId);
}
