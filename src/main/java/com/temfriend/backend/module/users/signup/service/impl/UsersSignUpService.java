package com.temfriend.backend.module.users.signup.service.impl;

import com.temfriend.backend.module.users.common.service.UsersPasswordService;
import com.temfriend.backend.module.users.common.service.UsersSaveService;
import com.temfriend.backend.module.users.common.service.UsersValidator;
import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest;
import com.temfriend.backend.module.users.signup.dto.rseponse.UsersSignUpResponse;
import com.temfriend.backend.module.users.signup.mapper.UsersSignUpMapper;
import com.temfriend.backend.module.users.signup.service.UsersSignUpUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersSignUpService implements UsersSignUpUsecase {
    private static final String SIGN_UP_SUCCESS_MESSAGE = "회원가입에 성공했습니다.";
    private final UsersSaveService usersSaveService;
    private final UsersValidator usersValidator;
    private final UsersPasswordService usersPasswordService;

    @Override
    public UsersSignUpResponse.Create executeSignUp(UsersSignUpRequest.Create request) {
        Users users = makeUsersFrom(request);
        usersSaveService.save(users);

        return UsersSignUpResponse.Create.builder()
                .message(SIGN_UP_SUCCESS_MESSAGE)
                .build();
    }

    private Users makeUsersFrom(UsersSignUpRequest.Create request) {
        usersValidator.validateSignUpRequest(request);
        String encodedPassword = usersPasswordService.encode(request.password());

        return UsersSignUpMapper.INSTANCE
                .convertUsersFrom(request, encodedPassword);
    }
}
