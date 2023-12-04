package com.temfriend.backend.global.jwt;

import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.users.domain.Users;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JWTProvider {
    private static final String EMAIL = "email";
    private static final String ID = "id";
    private final JWTProperties jwtProperties;

    public String generateToken(Users users) {
        Date now = new Date();
        Date expiration = new Date();
        expiration.setTime(expiration.getTime() + jwtProperties.getExpired());

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .claim(EMAIL, users.getEmail())
                .claim(ID, users.getId())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public CustomUsersDetail getCustomUsersDetail(String token) {
        Long id = getUserIdByToken(token);
        String email = getUserEmailByToken(token);

        return CustomUsersDetail.builder()
                .id(id)
                .email(email)
                .build();
    }

    private Long getUserIdByToken(String token) {
        Claims claims = getClaims(token);
        return claims.get(ID, Long.class);
    }

    private String getUserEmailByToken(String token) {
        Claims claims = getClaims(token);
        return claims.get(EMAIL, String.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtProperties.getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
