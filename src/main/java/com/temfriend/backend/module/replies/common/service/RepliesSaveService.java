package com.temfriend.backend.module.replies.common.service;

import com.temfriend.backend.module.replies.domain.Replies;
import com.temfriend.backend.module.replies.domain.repository.RepliesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RepliesSaveService {
    private final RepliesRepository repliesRepository;

    public Replies save(Replies replies) {
        return repliesRepository.save(replies);
    }
}
