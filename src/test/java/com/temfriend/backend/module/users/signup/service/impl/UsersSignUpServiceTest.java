package com.temfriend.backend.module.users.signup.service.impl;

import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import com.temfriend.backend.module.users.signup.dto.rseponse.UsersSignUpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Service : UsersSignUpService")
@SpringBootTest
class UsersSignUpServiceTest {
    private static final String EMAIL = "tester@test.com";
    private static final String PASSWORD = "password123";
    private static final String CONFIRM_PASSWORD = "password123";
    private static final String NAME = "홍길동";
    private static final String NICKNAME = "의적";
    private static final String IMG = "img.png";

    private static final String SIGN_UP_SUCCESS_MESSAGE = "회원가입에 성공했습니다.";

    @Autowired
    private UsersSignUpService usersSignUpService;
    @Autowired
    private UsersRepository usersRepository;

    private UsersSignUpRequest.Create usersSignUpRequest;

    @BeforeEach
    void initialize() {
        this.usersRepository.deleteAll();
        this.usersSignUpRequest = generateValidRequest();
    }

    @DisplayName("Success : 유저 회원 가입에 성공할 것이다.")
    @Test
    void success_usersSignUpTest() {
        UsersSignUpResponse.Create response = usersSignUpService.executeSignUp(this.usersSignUpRequest);

        Optional<Users> optionalUsers = usersRepository.findByEmail(EMAIL);

        assertThat(optionalUsers.isPresent())
                .isTrue();

        assertThat(response.message())
                .isEqualTo(SIGN_UP_SUCCESS_MESSAGE);

        Users users = optionalUsers.get();
        assertThat(users.getEmail())
                .isEqualTo(EMAIL);
    }

    private static UsersSignUpRequest.Create generateValidRequest() {
        return UsersSignUpRequest.Create.builder()
                .email(EMAIL)
                .name(NAME)
                .password(PASSWORD)
                .confirmPassword(CONFIRM_PASSWORD)
                .nickname(NICKNAME)
                .img(IMG)
                .build();
    }
}