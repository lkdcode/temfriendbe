package com.temfriend.backend.module.replies.common.service;

import com.temfriend.backend.module.replies.common.exception.custom.NotFoundRepliesByIdException;
import com.temfriend.backend.module.replies.common.exception.error.RepliesErrorCode;
import com.temfriend.backend.module.replies.domain.Replies;
import com.temfriend.backend.module.replies.domain.repository.RepliesRepository;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RepliesLoadService {
    private final RepliesRepository repliesRepository;

    public Replies loadRepliesByUsers(Users users) {
        return repliesRepository.findByUsers(users)
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    public Replies loadRepliesById(Long id) {
        return repliesRepository.findById(id)
                .orElseThrow(() -> new NotFoundRepliesByIdException(RepliesErrorCode.NOT_FOUNT_REPLIES_FROM_ID));
    }

    public List<Replies> loadRepliesListByPostsId(Long postsId) {
        return repliesRepository.findByPostsId(postsId);
    }
}
