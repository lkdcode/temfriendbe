package com.temfriend.backend.module.users.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Domain : Users")
class UsersTest {
    private static final String EMAIL = "tester@test.com";
    private static final String PASSWORD = "password123";
    private static final String NAME = "홍길동";
    private static final String NICKNAME = "tester";
    private static final String IMG = "test.png";
    private static final String DEFAULT_AUTHORITY = "USERS";
    private static final String DEFAULT_GRADE = "BRONZE";
    private static final String DEFAULT_STATUS = "Y";

    private static final String REMOVE_MARK = "N";

    private Users users;

    @BeforeEach
    void init() {
        this.users = generateUsers();
    }

    @Test
    @DisplayName("Success : 유저 생성에 성공할 것이다.")
    void success_createUsersTest() {
        assertThat(users.getEmail()).isEqualTo(EMAIL);
        assertThat(users.getPassword()).isEqualTo(PASSWORD);
        assertThat(users.getName()).isEqualTo(NAME);
        assertThat(users.getNickname()).isEqualTo(NICKNAME);
        assertThat(users.getImg()).isEqualTo(IMG);
        assertThat(users.getAuthority()).isEqualTo(DEFAULT_AUTHORITY);
        assertThat(users.getGrade()).isEqualTo(DEFAULT_GRADE);
        assertThat(users.getStatus()).isEqualTo(DEFAULT_STATUS);
    }

    @Test
    @DisplayName("Success : 유저 삭제는 'Y' 로 마킹에 성공할 것이다.")
    void success_removeUsersTest() {
        users.remove();
        String status = users.getStatus();

        assertThat(status)
                .isEqualTo(REMOVE_MARK);
    }

    private static Users generateUsers() {
        return Users.builder()
                .email(EMAIL)
                .password(PASSWORD)
                .name(NAME)
                .nickname(NICKNAME)
                .img(IMG)
                .build();
    }
}