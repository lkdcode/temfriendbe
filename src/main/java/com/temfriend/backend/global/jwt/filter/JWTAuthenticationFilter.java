package com.temfriend.backend.global.jwt.filter;

import com.temfriend.backend.global.jwt.JWTProvider;
import com.temfriend.backend.global.security.cookie.CookieProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private final JWTProvider jwtProvider;
    private final CookieProvider cookieProvider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain
    ) throws ServletException, IOException {
        String cookie = cookieProvider.findCookieByKey(request, jwtProvider.getAuthorization());
        String token = jwtProvider.parseToken(cookie);
        boolean validateToken = jwtProvider.validateToken(token);

        if (validateToken) {
            UsernamePasswordAuthenticationToken authentication =
                    jwtProvider.getUsernamePasswordAuthenticationToken(token);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
