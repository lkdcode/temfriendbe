package com.temfriend.backend.modules.member.domain.repository;

import com.temfriend.backend.modules.member.domain.Member;
import com.temfriend.backend.modules.member.domain.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void initialize() {
    }

    @Test
    @DisplayName("signup Test")
    void signupTest() {
        // given
        final String memberAccount = "temfriend@naver.com";
        final String memberPassword = "qwer1234!";
        final String memberImg = "amazon";
        final String memberName = "홍길동";
        final String memberNickname = "Java";

        // when
        Member member = Member.builder()
                .account(memberAccount)
                .password(memberPassword)
                .profile(Profile.builder()
                        .name(memberName)
                        .nickname(memberNickname)
                        .img(memberImg)
                        .build())
                .build();

        Member save = memberRepository.save(member);

        // then
        Assertions.assertEquals("홍길동", save.getName());

    }

}