package com.temfriend.backend.module.users.signup.api;

import com.temfriend.backend.global.base.BaseApiControllerTest;
import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Api : UsersSignUpApiControllerTest")
class UsersSignUpApiControllerTest extends BaseApiControllerTest {
    private static final String EMAIL = "tester@test.com";
    private static final String PASSWORD = "passWORD123!@#";
    private static final String CONFIRM_PASSWORD = "passWORD123!@#";
    private static final String NAME = "홍길동";
    private static final String NICKNAME = "의적";
    private static final String IMG = "img.png";
    private static final String SIGN_UP_SUCCESS_MESSAGE = "회원가입에 성공했습니다.";
    private static final String SUCCESS_MESSAGE = "요청을 성공적으로 불러왔습니다.";
    private static final String URL = "/api/users/sign-up";
    @Autowired
    private UsersSignUpApiController controller;
    @Autowired
    private UsersRepository usersRepository;

    @DisplayName("Success : 올바른 이메일은 회원가입 요청에 성공할 것이다.")
    @ParameterizedTest(name = "Valid email : \"{0}\"")
    @ValueSource(strings = {"tester@test.com", "test123@test.io", "test@test.net", "test@test.store"})
    void success_signUpRequestWithValidEmailTest(String email) throws Exception {
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(generateValidRequestFromEmail(email))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.payload.message").value(SIGN_UP_SUCCESS_MESSAGE))
                .andExpect(jsonPath("$.message").value(SUCCESS_MESSAGE));

        Optional<Users> optionalUsers = usersRepository.findByEmail(email);

        assertThat(optionalUsers.isPresent())
                .isTrue();

        Users users = optionalUsers.get();

        assertThat(users.getEmail())
                .isEqualTo(email);
    }

    @DisplayName("Success : 올바른 패스워드는 회원가입 요청에 성공할 것이다.")
    @ParameterizedTest(name = "Valid password : \"{0}\"")
    @ValueSource(strings = {"passWord123!", "Password@123", "passwordGood1@", "PassWord0*"})
    void success_signUpRequestWithValidPasswordTest(String password) throws Exception {
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(generateValidRequestFromPassword(password))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.payload.message").value(SIGN_UP_SUCCESS_MESSAGE))
                .andExpect(jsonPath("$.message").value(SUCCESS_MESSAGE));

        Optional<Users> optionalUsers = usersRepository.findByEmail(EMAIL);

        assertThat(optionalUsers.isPresent())
                .isTrue();

        Users users = optionalUsers.get();

        assertThat(users.getEmail())
                .isEqualTo(EMAIL);
    }

    @DisplayName("Exception : 유효하지 않은 이메일 포함한 회원가입 요청은 익셉션을 발생시킬 것이다.")
    @ParameterizedTest(name = "Invalid Email: \"{0}\"")
    @ValueSource(strings = {"tester#test.com", "tester@testcom", "testertestcom", "536782.com"})
    void exception_thrownInvalidRequestTest(String invalidEmail) throws Exception {
        String exceptionMessage = mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(generateInvalidEmailRequest(invalidEmail))))
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(exceptionMessage)
                .isEqualTo("올바른 이메일이 아닙니다.");
    }

    @DisplayName("Exception : 유효하지 않은 비밀번호를 포함한 회원가입 요청은 익셉션을 발생시킬 것이다.")
    @ParameterizedTest(name = "Invalid Password : \"{0}\"")
    @ValueSource(strings = {"password", "123123456", "password123", "pass", "password!@#$", "PASSword123", "password!@#$", "password!!123"})
    void exception_thrownInvalidRequestWithIncorrectPasswordTest(String invalidPassword) throws Exception {
        ResultActions resultActions = mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(generateInvalidPasswordRequest(invalidPassword))))
                .andExpect(status().isBadRequest());

        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        assertThat(responseBody)
                .isEqualTo("비밀번호는 8자리 이상 15자리 이하 대문자, 소문자, 특수 문자를 포함해야합니다.");
    }

    private static UsersSignUpRequest.Create generateValidRequestFromEmail(String email) {
        return UsersSignUpRequest.Create.builder()
                .email(email)
                .name(NAME)
                .password(PASSWORD)
                .confirmPassword(CONFIRM_PASSWORD)
                .nickname(NICKNAME)
                .img(IMG)
                .build();
    }

    private static UsersSignUpRequest.Create generateValidRequestFromPassword(String password) {
        return UsersSignUpRequest.Create.builder()
                .email(EMAIL)
                .name(NAME)
                .password(password)
                .confirmPassword(password)
                .nickname(NICKNAME)
                .img(IMG)
                .build();
    }

    private static UsersSignUpRequest.Create generateInvalidPasswordRequest(String invalidPassword) {
        return UsersSignUpRequest.Create.builder()
                .email(EMAIL)
                .name(NAME)
                .password(invalidPassword)
                .confirmPassword(invalidPassword)
                .nickname(NICKNAME)
                .img(IMG)
                .build();
    }

    private static UsersSignUpRequest.Create generateInvalidEmailRequest(String invalidEmail) {
        return UsersSignUpRequest.Create.builder()
                .email(invalidEmail)
                .name(NAME)
                .password(PASSWORD)
                .confirmPassword(CONFIRM_PASSWORD)
                .nickname(NICKNAME)
                .img(IMG)
                .build();
    }
}