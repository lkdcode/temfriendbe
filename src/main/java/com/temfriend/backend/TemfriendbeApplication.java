package com.temfriend.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TemfriendbeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemfriendbeApplication.class, args);
    }

}
