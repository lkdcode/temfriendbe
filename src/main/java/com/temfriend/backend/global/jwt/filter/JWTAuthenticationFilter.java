package com.temfriend.backend.global.jwt.filter;

import com.temfriend.backend.global.jwt.JWTProvider;
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
    private final static String HEADER_AUTHORIZATION = "Authorization";
    private final static String TOKEN_PREFIX = "Bearer ";
    private final JWTProvider jwtProvider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain
    ) throws ServletException, IOException {
        String accessToken = extractTokenFromHeader(request);

        if (accessToken != null && jwtProvider.validateToken(accessToken)) {
            UsernamePasswordAuthenticationToken authentication =
                    jwtProvider.getUsernamePasswordAuthenticationToken(accessToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private static String extractTokenFromHeader(HttpServletRequest request) {
        String authorizationHeader = getAuthorizationHeader(request);
        return getAccessToken(authorizationHeader);
    }

    private static String getAuthorizationHeader(HttpServletRequest request) {
        return request.getHeader(HEADER_AUTHORIZATION);
    }

    private static String getAccessToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)) {
            return authorizationHeader.substring(TOKEN_PREFIX.length());
        }

        return null;
    }
}
