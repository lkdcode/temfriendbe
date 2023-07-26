package com.temfriend.backend.modules.post.service.post;

import com.temfriend.backend.modules.post.controller.dto.mapper.PostMapper;
import com.temfriend.backend.modules.post.controller.dto.request.PostCreateRequestDTO;
import com.temfriend.backend.modules.post.domain.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@Rollback
class PostCreateServiceTest {

    @Autowired
    private PostCreateService postCreateService;

    @Test
    @DisplayName("포스트 작성에 성공할 것이다.")
    void postCreateTest() {

        // given
        boolean isCreate =
                postCreateService.create(
                        Post.builder()
                                .content("postTest")
                                .startDt(LocalDateTime.now())
                                .endDt(LocalDateTime.now())
                                .build()
                );
        // when
        // then
        assertTrue(isCreate);

    }
}