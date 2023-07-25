package com.temfriend.backend.modules.post.service.post.impl;

import com.temfriend.backend.modules.post.domain.Post;
import com.temfriend.backend.modules.post.domain.repository.PostRepository;
import com.temfriend.backend.modules.post.service.post.PostReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostingReadService implements PostReadService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getPostList() {
        try {
            return postRepository.findAll();
        } catch (Exception e) {
            throw new IllegalArgumentException("전체 목록 조회 실패");
        }
    }

    @Override
    public Post getPost(Post post) {
        Optional<Post> byId = postRepository.findById(post.getId());
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new IllegalArgumentException("게시글 없음");
    }
}
