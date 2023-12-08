package com.temfriend.backend.module.replies.common.service;

import com.temfriend.backend.module.replies.common.exception.custom.RepliesAccessDeniedException;
import com.temfriend.backend.module.replies.common.exception.enums.RepliesErrorCode;
import com.temfriend.backend.module.replies.domain.Replies;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RepliesValidator {
    public void validateAuthorship(Replies replies, Users users) {
        String auth = replies.getUsers().getEmail();

        if (!auth.equals(users.getEmail())) {
            throw new RepliesAccessDeniedException(RepliesErrorCode.NOT_MATCHES);
        }
    }
}
