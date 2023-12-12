package com.temfriend.backend.module.users.global.service;

import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import com.temfriend.backend.module.users.global.exception.custom.DuplicateUsersException;
import com.temfriend.backend.module.users.global.exception.custom.PasswordMismatchException;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Service : UsersValidator")
@SpringBootTest
class UsersValidatorTest {
    private static final String SAVED_EMAIL = "tester@test.com";
    private static final String ANOTHER_EMAIL = "anotherTester@test.com";
    private static final String PASSWORD = "password123";
    private static final String NAME = "홍길동";
    private static final String SAVED_NICKNAME = "의적";
    private static final String ANOTHER_NICKNAME = "도적";
    private static final String IMG = "img.png";
    private static final String VALID_CONFIRM_PASSWORD = "password123";
    private static final String INVALID_CONFIRM_PASSWORD = "321password";

    @Autowired
    private UsersValidator usersValidator;
    @Autowired
    private UsersRepository usersRepository;

    @BeforeEach
    void initialize() {
        this.usersRepository.deleteAll();

        this.usersRepository.save(Users.builder()
                .email(SAVED_EMAIL)
                .password(PASSWORD)
                .name(NAME)
                .nickname(SAVED_NICKNAME)
                .img(IMG)
                .build());
    }

    @DisplayName("Success : 유효한 리퀘스트는 익셉션이 발생하지 않을 것이다.")
    @Test
    void success_validRequestTest() {
        assertThatCode(() -> usersValidator.validateSignUpRequest(generateValidRequest()))
                .doesNotThrowAnyException();
    }

    @DisplayName("Exception : 두 비밀번호가 일치하지 않으면 익셉션이 발생할 것이다.")
    @Test
    void exception_thrownForMismatchPasswordRequestTest() {
        assertThatCode(() -> usersValidator.validateSignUpRequest(generateMismatchPasswordRequest()))
                .isInstanceOf(PasswordMismatchException.class);
    }

    @DisplayName("Exception : 중복된 이메일은 익셉션이 발생할 것이다.")
    @Test
    void exception_thrownForDuplicateEmailRequestTest() {
        assertThatCode(() -> usersValidator.validateSignUpRequest(generateDuplicateEmailRequest()))
                .isInstanceOf(DuplicateUsersException.class);
    }

    @DisplayName("Exception : 중복된 닉네임은 익셉션이 발생할 것이다.")
    @Test
    void exception_thrownForDuplicateNicknameRequestTest() {
        assertThatCode(() -> usersValidator.validateSignUpRequest(generateDuplicateNicknameRequest()))
                .isInstanceOf(DuplicateUsersException.class);
    }

    private static UsersSignUpRequest.Create generateValidRequest() {
        return UsersSignUpRequest.Create.builder()
                .email(ANOTHER_EMAIL)
                .name(NAME)
                .password(PASSWORD)
                .confirmPassword(VALID_CONFIRM_PASSWORD)
                .nickname(ANOTHER_NICKNAME)
                .img(IMG)
                .build();
    }

    private static UsersSignUpRequest.Create generateMismatchPasswordRequest() {
        return UsersSignUpRequest.Create.builder()
                .email(ANOTHER_EMAIL)
                .name(NAME)
                .password(PASSWORD)
                .confirmPassword(INVALID_CONFIRM_PASSWORD)
                .nickname(ANOTHER_NICKNAME)
                .img(IMG)
                .build();
    }

    private static UsersSignUpRequest.Create generateDuplicateEmailRequest() {
        return UsersSignUpRequest.Create.builder()
                .email(SAVED_EMAIL)
                .name(NAME)
                .password(PASSWORD)
                .confirmPassword(VALID_CONFIRM_PASSWORD)
                .nickname(ANOTHER_NICKNAME)
                .img(IMG)
                .build();
    }

    private static UsersSignUpRequest.Create generateDuplicateNicknameRequest() {
        return UsersSignUpRequest.Create.builder()
                .email(ANOTHER_EMAIL)
                .name(NAME)
                .password(PASSWORD)
                .confirmPassword(VALID_CONFIRM_PASSWORD)
                .nickname(SAVED_NICKNAME)
                .img(IMG)
                .build();
    }
}