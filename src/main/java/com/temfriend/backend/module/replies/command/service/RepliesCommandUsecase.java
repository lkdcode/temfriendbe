package com.temfriend.backend.module.replies.command.service;

import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.replies.command.dto.request.RepliesRequestDTO;
import com.temfriend.backend.module.replies.command.dto.response.RepliesResponseDTO;

public interface RepliesCommandUsecase {
    RepliesResponseDTO.Create executeRepliesSave(Long postsId, RepliesRequestDTO.Create request, CustomUsersDetail customUsersDetail);

    RepliesResponseDTO.Update executeRepliesUpdate(Long repliesId, RepliesRequestDTO.Update request, CustomUsersDetail customUsersDetail);

    RepliesResponseDTO.Delete executeRepliesDelete(Long repliesId, CustomUsersDetail customUsersDetail);
}
