package com.temfriend.backend.module.users.auth.service;

import com.temfriend.backend.global.jwt.JWTProvider;
import com.temfriend.backend.global.security.cookie.CookieProvider;
import com.temfriend.backend.module.activities.domain.Activities;
import com.temfriend.backend.module.activities.domain.repository.ActivitiesRepository;
import com.temfriend.backend.module.points.domain.Points;
import com.temfriend.backend.module.points.domain.repository.PointsRepository;
import com.temfriend.backend.module.users.auth.dto.request.AuthRequestDTO;
import com.temfriend.backend.module.users.auth.dto.response.AuthResponseDTO;
import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import com.temfriend.backend.module.users.global.exception.custom.LogInFailException;
import com.temfriend.backend.module.users.global.service.UsersPasswordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.Cookie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class AuthServiceTest {
    private static final String SAVED_EMAIL = "tester@test.com";
    private static final String PASSWORD = "password123!@#";
    private static final String NAME = "홍길동";
    private static final String SAVED_NICKNAME = "의적";
    private static final String IMG = "img.png";

    @Autowired
    private AuthService authService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersPasswordService usersPasswordService;

    @Autowired
    private PointsRepository pointsRepository;

    @Autowired
    private ActivitiesRepository activitiesRepository;

    @Autowired
    private CookieProvider cookieProvider;
    @Autowired
    private JWTProvider jwtProvider;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;


    @BeforeEach
    void saveUsersToRepository() {
        this.usersRepository.deleteAll();
        this.pointsRepository.deleteAll();
        this.activitiesRepository.deleteAll();

        Users users = Users.builder()
                .email(SAVED_EMAIL)
                .password(usersPasswordService.encode(PASSWORD))
                .name(NAME)
                .nickname(SAVED_NICKNAME)
                .img(IMG)
                .build();
        this.usersRepository.save(users);
        this.pointsRepository.save(Points.newInstance(users));
        this.activitiesRepository.save(Activities.builder()
                .users(users)
                .build());
    }

    @DisplayName("Success : 이미 가입된 유저의 아이디와 비밀번호로 로그인에 성공할 것이다.")
    @Test
    void success_logInTest() {
        MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
        AuthRequestDTO.LogIn request = AuthRequestDTO.LogIn.builder()
                .email(SAVED_EMAIL)
                .password(PASSWORD)
                .build();

        AuthResponseDTO.LogIn logIn = authService.executeLogIn(httpServletResponse, request);
        Cookie authorization = httpServletResponse.getCookie("Authorization");

        assertThat(authorization)
                .isNotNull();

        assertThat(authorization.getName())
                .isEqualTo("Authorization");

        assertThat(authorization.getValue())
                .startsWith("Bearer");

        assertThat(logIn.accessToken())
                .isNotNull();

        assertThat(logIn.message())
                .isEqualTo("로그인에 성공했습니다.");
    }

    @DisplayName("Exception : 가입되지 않은 이메일로 로그인 시 익셉션이 발생할 것이다.")
    @Test
    void exception_failLogInWithInvalidEmailTest() {
        MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
        AuthRequestDTO.LogIn request = AuthRequestDTO.LogIn.builder()
                .email("test@test.io")
                .password(PASSWORD)
                .build();

        assertThatThrownBy(() -> authService.executeLogIn(httpServletResponse, request))
                .isInstanceOf(LogInFailException.class)
                .hasMessage("아이디 혹은 비밀번호가 틀렸습니다.");

        Cookie authorization = httpServletResponse.getCookie("Authorization");

        assertThat(authorization)
                .isNull();
    }

    @DisplayName("Exception : 유효하지 않은 이메일로 로그인 시 익셉션이 발생할 것이다.")
    @Test
    void exception_failLogInWithInvalidPasswordTest() {
        MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
        AuthRequestDTO.LogIn request = AuthRequestDTO.LogIn.builder()
                .email(SAVED_EMAIL)
                .password("!@#123password")
                .build();

        assertThatThrownBy(() -> authService.executeLogIn(httpServletResponse, request))
                .isInstanceOf(LogInFailException.class)
                .hasMessage("아이디 혹은 비밀번호가 틀렸습니다.");

        Cookie authorization = httpServletResponse.getCookie("Authorization");

        assertThat(authorization)
                .isNull();
    }

    @DisplayName("Success : 로그아웃하는 토큰은 블랙리스트에 추가할 것이다.")
    @Test
    void success_logOutBlackListTest() {
//        String authorizationKey = "Authorization";
//        String token = "testToken";
//
//        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
//        MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
//
//        AuthResponseDTO.LogOut result = authService.executeLogOut(httpServletRequest, httpServletResponse);
//
//        System.out.println(result);
    }
}