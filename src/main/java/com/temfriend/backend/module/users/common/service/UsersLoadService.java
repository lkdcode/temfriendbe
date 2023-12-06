package com.temfriend.backend.module.users.common.service;

import com.temfriend.backend.module.users.common.exception.custom.LogInFailException;
import com.temfriend.backend.module.users.common.exception.custom.NotFoundUsersByEmailException;
import com.temfriend.backend.module.users.common.exception.enums.UsersException;
import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersLoadService {
    private final UsersRepository usersRepository;

    public Users loadUsersFromEmail(String email) {
        return usersRepository.findByEmail(email).orElseThrow(() ->
                new NotFoundUsersByEmailException(UsersException.NOT_FOUNT_USERS_FROM_EMAIL));
    }

    public Users loadUsersFromLogInEmail(String email) {
        return usersRepository.findByEmail(email).orElseThrow(() ->
                new LogInFailException(UsersException.LOGIN_FAIL_INVALID_CREDENTIALS));
    }
}
