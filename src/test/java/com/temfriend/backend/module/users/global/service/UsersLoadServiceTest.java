package com.temfriend.backend.module.users.global.service;

import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import com.temfriend.backend.module.users.global.exception.custom.LogInFailException;
import com.temfriend.backend.module.users.global.exception.custom.NotFoundUsersByEmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class UsersLoadServiceTest {
    private static final String SAVED_EMAIL = "tester@test.com";
    private static final String PASSWORD = "password123";
    private static final String NAME = "홍길동";
    private static final String SAVED_NICKNAME = "의적";
    private static final String IMG = "img.png";
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersLoadService usersLoadService;

    @BeforeEach
    void initializeRepository() {
        this.usersRepository.deleteAll();

        this.usersRepository.save(Users.builder()
                .email(SAVED_EMAIL)
                .password(PASSWORD)
                .name(NAME)
                .nickname(SAVED_NICKNAME)
                .img(IMG)
                .build());
    }

    @DisplayName("Success : 저장된 이메일로 유저를 불러오는데 성공할 것이다.")
    @Test
    void success_loadUsersWithSavedEmailTest() {
        Users users = usersLoadService.loadUsersFromEmail(SAVED_EMAIL);

        assertThat(users.getEmail())
                .isEqualTo(SAVED_EMAIL);

        assertThat(users.getPassword())
                .isEqualTo(PASSWORD);

        assertThat(users.getNickname())
                .isEqualTo(SAVED_NICKNAME);
    }

    @DisplayName("Exception : 저장되지 않은 이메일로 저장된 유저를 불러오면 익셉션이 발생할 것이다.")
    @Test
    void exception_loadUsersWithNonSavedEmailTest() {
        String nonSavedEmail = "test@test.io";
        assertThatThrownBy(() -> usersLoadService.loadUsersFromEmail(nonSavedEmail))
                .isInstanceOf(NotFoundUsersByEmailException.class)
                .hasMessage("해당 이메일의 유저는 존재하지 않습니다.");
    }


    @DisplayName("Success : 저장된 이메일로 로그인 시 유저를 불러오는데 성공할 것이다.")
    @Test
    void success_loadUsersWithSavedEmailForLogInTest() {
        Users users = usersLoadService.loadUsersFromLogInEmail(SAVED_EMAIL);

        assertThat(users.getEmail())
                .isEqualTo(SAVED_EMAIL);

        assertThat(users.getPassword())
                .isEqualTo(PASSWORD);

        assertThat(users.getNickname())
                .isEqualTo(SAVED_NICKNAME);
    }

    @DisplayName("Exception : 저장되지 않은 이메일로 로그인 시 익셉션이 발생할 것이다.")
    @Test
    void exception_loadUsersWithNonSavedEmailForLogInTest() {
        String nonSavedEmail = "test@test.io";
        assertThatThrownBy(() -> usersLoadService.loadUsersFromLogInEmail(nonSavedEmail))
                .isInstanceOf(LogInFailException.class)
                .hasMessage("아이디 혹은 비밀번호가 틀렸습니다.");
    }
}