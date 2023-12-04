package com.temfriend.backend.global.jwt;

import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.users.domain.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JWTProvider {
    private static final String EMAIL = "email";
    private static final String ID = "id";
    private static final String GRADE = "grade";
    private static final String AUTHORITY = "authority";
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
                .claim(GRADE, users.getGrade())
                .claim(AUTHORITY, users.getAuthority())
                .signWith(jwtProperties.getSecretKey(), SignatureAlgorithm.HS256)
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

    public UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String token) {
        CustomUsersDetail customUsersDetail = getCustomUsersDetail(token);

        return new UsernamePasswordAuthenticationToken(
                customUsersDetail, "", customUsersDetail.getAuthorities()
        );
    }

    private CustomUsersDetail getCustomUsersDetail(String token) {
        Long id = getUserIdByToken(token);
        String email = getUserEmailByToken(token);
        String grade = getUserGradeByToken(token);
        String authority = getUserAuthorityByToken(token);

        return CustomUsersDetail.builder()
                .id(id)
                .email(email)
                .authorities(List.of(grade, authority))
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

    private String getUserGradeByToken(String token) {
        Claims claims = getClaims(token);
        return claims.get(GRADE, String.class);
    }

    private String getUserAuthorityByToken(String token) {
        Claims claims = getClaims(token);
        return claims.get(AUTHORITY, String.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtProperties.getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
