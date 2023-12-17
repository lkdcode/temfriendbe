package com.temfriend.backend.module.users.global.service;

import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import com.temfriend.backend.module.users.global.exception.custom.DuplicateUsersException;
import com.temfriend.backend.module.users.global.exception.custom.PasswordMismatchException;
import com.temfriend.backend.module.users.global.exception.error.UsersErrorCode;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersValidator {
    private final UsersRepository usersRepository;

    public void validateSignUpRequest(UsersSignUpRequest.Create request) throws PasswordMismatchException, DuplicateUsersException {
        verifyDuplicateEmail(request.email());
        verifyDuplicateNickname(request.nickname());
        verifyInputPasswords(request.password(), request.confirmPassword());
    }

    private void verifyInputPasswords(String password, String confirmPassword) throws PasswordMismatchException {
        if (!password.equals(confirmPassword)) {
            throw new PasswordMismatchException(UsersErrorCode.PASSWORD_MISMATCH_ERROR);
        }
    }

    private void verifyDuplicateEmail(String email) throws DuplicateUsersException {
        boolean exists = usersRepository.existsByEmail(email);
        if (exists) {
            throw new DuplicateUsersException(UsersErrorCode.DUPLICATE_USERS_EMAIL);
        }
    }

    private void verifyDuplicateNickname(String nickname) throws DuplicateUsersException {
        boolean exists = usersRepository.existsByProfile_Nickname(nickname);
        if (exists) {
            throw new DuplicateUsersException(UsersErrorCode.DUPLICATE_USERS_NICKNAME);
        }
    }
}
