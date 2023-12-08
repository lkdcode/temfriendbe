package com.temfriend.backend.module.users.common.service;

import com.temfriend.backend.module.users.auth.dto.request.AuthRequestDTO;
import com.temfriend.backend.module.users.common.exception.custom.DuplicateUsersException;
import com.temfriend.backend.module.users.common.exception.custom.NotFoundUsersByEmailException;
import com.temfriend.backend.module.users.common.exception.custom.PasswordMismatchException;
import com.temfriend.backend.module.users.common.exception.error.UsersErrorCode;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersValidator {
    private final UsersRepository usersRepository;

    public void validateSignUpRequest(UsersSignUpRequest.Create request) {
        verifyDuplicateEmail(request.email());
        verifyDuplicateNickname(request.nickname());
        verifyInputPasswords(request.password(), request.confirmPassword());
    }

    public void validateLogInRequest(AuthRequestDTO.LogIn request) {
        verifyUserNotExistsByEmail(request.email());
    }

    private void verifyInputPasswords(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new PasswordMismatchException(UsersErrorCode.PASSWORD_MISMATCH_ERROR);
        }
    }

    private void verifyDuplicateEmail(String email) {
        boolean exists = usersRepository.existsByEmail(email);
        if (exists) {
            throw new DuplicateUsersException(UsersErrorCode.DUPLICATE_USERS_EMAIL);
        }
    }

    private void verifyDuplicateNickname(String nickname) {
        boolean exists = usersRepository.existsByProfile_Nickname(nickname);
        if (exists) {
            throw new DuplicateUsersException(UsersErrorCode.DUPLICATE_USERS_NICKNAME);
        }
    }

    private void verifyUserNotExistsByEmail(String email) {
        boolean exists = usersRepository.existsByEmail(email);
        if (exists) {
            throw new NotFoundUsersByEmailException(UsersErrorCode.NOT_FOUNT_USERS_FROM_EMAIL);
        }
    }
}
