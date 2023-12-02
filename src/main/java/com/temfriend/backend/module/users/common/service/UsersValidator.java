package com.temfriend.backend.module.users.common.service;

import com.temfriend.backend.module.users.common.exception.custom.DuplicateUsersException;
import com.temfriend.backend.module.users.common.exception.enums.UsersException;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersValidator {
    private final UsersRepository usersRepository;

    public void validateSignupRequest(UsersSignUpRequest.Create request) {
        validateDuplicateEmail(request.email());
        validateDuplicateNickname(request.nickName());
    }

    public void validateDuplicateEmail(String email) {
        boolean exists = usersRepository.existsByEmail(email);
        if (exists) {
            throw new DuplicateUsersException(UsersException.DUPLICATE_USERS_EMAIL);
        }
    }

    public void validateDuplicateNickname(String nickname) {
        boolean exists = usersRepository.existsByNickname(nickname);
        if (exists) {
            throw new DuplicateUsersException(UsersException.DUPLICATE_USERS_NICKNAME);
        }
    }
}
