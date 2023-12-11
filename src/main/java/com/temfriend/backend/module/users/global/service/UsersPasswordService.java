package com.temfriend.backend.module.users.global.service;

import com.temfriend.backend.module.users.global.exception.custom.LogInFailException;
import com.temfriend.backend.module.users.global.exception.error.UsersErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersPasswordService {
    private final PasswordEncoder passwordEncoder;

    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public void validatePassword(String rawPassword, String encodedPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new LogInFailException(UsersErrorCode.LOGIN_FAIL_INVALID_CREDENTIALS);
        }
    }
}
