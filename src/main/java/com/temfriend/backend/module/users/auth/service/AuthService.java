package com.temfriend.backend.module.users.auth.service;

import com.temfriend.backend.global.jwt.JWTProvider;
import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.global.security.cookie.CookieProvider;
import com.temfriend.backend.module.points.command.PointsCommandUsecase;
import com.temfriend.backend.module.users.auth.dto.request.AuthRequestDTO;
import com.temfriend.backend.module.users.auth.dto.response.AuthResponseDTO;
import com.temfriend.backend.module.users.common.service.UsersLoadService;
import com.temfriend.backend.module.users.common.service.UsersPasswordService;
import com.temfriend.backend.module.users.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private static final String LOGIN_SUCCESS_MESSAGE = "로그인에 성공했습니다.";
    private static final String LOGOUT_SUCCESS_MESSAGE = "로그아웃에 성공했습니다.";
    private final UsersLoadService usersLoadService;
    private final UsersPasswordService usersPasswordService;
    private final JWTProvider jwtProvider;
    private final CookieProvider cookieProvider;
    private final PointsCommandUsecase pointsCommandUsecase;

    public AuthResponseDTO.LogIn executeLogIn(HttpServletResponse httpServletResponse, AuthRequestDTO.LogIn request) {
        Users users = usersLoadService.loadUsersFromLogInEmail(request.email());
        usersPasswordService.validatePassword(request.password(), users.getPassword());

        String accessToken = jwtProvider.generateToken(users);
        cookieProvider.addCookieKeyAndValue(httpServletResponse, jwtProvider.getAuthorization(), accessToken);

        pointsCommandUsecase.executeIncrementPointsFromLogIn(users);

        return AuthResponseDTO.LogIn.builder()
                .message(LOGIN_SUCCESS_MESSAGE)
                .accessToken(accessToken)
                .build();
    }

    public AuthResponseDTO.LogOut executeLogOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, CustomUsersDetail customUsersDetail) {
        String key = jwtProvider.getAuthorization();
        String token = cookieProvider.findCookieByKey(httpServletRequest, key);

        jwtProvider.addBlackListToken(token);
        cookieProvider.removeCookieByKey(httpServletResponse, key);

        return new AuthResponseDTO.LogOut(LOGOUT_SUCCESS_MESSAGE);
    }
}
