package com.temfriend.backend.global.jwt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Config : JWTProperties 설정")
@SpringBootTest
class JWTPropertiesTest {

    @Autowired
    private JWTProperties jwtProperties;

    @DisplayName("Success : JTWProperties 설정에 성공할 것이다.")
    @Test
    void success_JWTPropertiesConfigTest() {
        assertThat(jwtProperties.getExpired())
                .isNotNull();

        assertThat(jwtProperties.getSecretKey())
                .isNotNull();

        assertThat(jwtProperties.getIssuer())
                .isNotNull();
    }
}