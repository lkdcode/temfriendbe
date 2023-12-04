package com.temfriend.backend;

import com.temfriend.backend.global.jwt.JWTProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties(JWTProperties.class)
public class TemfriendbeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemfriendbeApplication.class, args);
    }

}
