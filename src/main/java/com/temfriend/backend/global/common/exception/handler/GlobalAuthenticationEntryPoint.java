package com.temfriend.backend.global.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class GlobalAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private static final String MESSAGE = "로그인 후 이용해주세요.";
    private static final String UTF = "UTF-8";
    private static final String CHAR_SET = ";charset=UTF-8";

    @Override
    public void commence(
            HttpServletRequest request
            , HttpServletResponse response
            , AuthenticationException authException) throws IOException, ServletException {
        log.error("[AuthenticationEntryPoint] : 유효하지 않은 사용자 입니다. responseMessage : {}", MESSAGE);

        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE + CHAR_SET);
        response.setCharacterEncoding(UTF);
        response.getWriter().write(MESSAGE);
    }
}
