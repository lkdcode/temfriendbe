package com.temfriend.backend.modules.post.domain.repository;

import com.temfriend.backend.modules.post.domain.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DataJpaTest
class PostReplyRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @BeforeEach
    void initialize() {
    }

    @Test
    @DisplayName("test")
    void test() {
        // given


        // when


        // then

    }

}