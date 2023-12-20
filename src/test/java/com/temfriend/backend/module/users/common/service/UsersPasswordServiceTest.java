package com.temfriend.backend.module.users.common.service;

import com.temfriend.backend.module.users.common.exception.custom.LogInFailException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UsersPasswordServiceTest {

    @Autowired
    private UsersPasswordService usersPasswordService;

    @DisplayName("Success : 비밀번호 인코딩에 성공할 것이다.")
    @Test
    void success_passwordEncodingTest() {
        String password = "password123!@#";
        String encodedPassword = usersPasswordService.encode(password);

        assertThat(encodedPassword)
                .isNotNull();

        assertThat(encodedPassword)
                .isNotEqualTo(password);
    }

    @DisplayName("Success : 인코딩된 비밀번호 검증에 성공할 것이다.")
    @Test
    void success_validatingEncodedPasswordTest() {
        String password = "password123!@#";
        String encodedPassword = usersPasswordService.encode(password);

        assertThatCode(() -> usersPasswordService.validatePassword(password, encodedPassword))
                .doesNotThrowAnyException();
    }

    @DisplayName("Exception : 인코딩된 비밀번호와 다른 비밀번호 검증 시 익셉션이 발생할 것이다.")
    @Test
    void exception_invalidPasswordValidationTest() {
        String password = "password123!@#";
        String encodedPassword = usersPasswordService.encode(password);
        String anotherPassword = "!@#123password";

        assertThatThrownBy(() -> usersPasswordService.validatePassword(anotherPassword, encodedPassword))
                .isInstanceOf(LogInFailException.class)
                .hasMessage("아이디 혹은 비밀번호가 틀렸습니다.");
    }
}