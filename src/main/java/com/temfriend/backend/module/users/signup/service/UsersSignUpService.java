package com.temfriend.backend.module.users.signup.service;

import com.temfriend.backend.module.users.common.service.UsersPasswordService;
import com.temfriend.backend.module.users.common.service.UsersValidator;
import com.temfriend.backend.module.users.domain.Users;
import com.temfriend.backend.module.users.domain.repository.UsersRepository;
import com.temfriend.backend.module.users.signup.dto.rseponse.UsersSignUpResponse;
import com.temfriend.backend.module.users.signup.mapper.UsersSignUpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest.Create;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersSignUpService {
    private static final String SUCCESS_MESSAGE = "회원가입에 성공했습니다.";
    private final UsersRepository usersRepository;
    private final UsersValidator usersValidator;
    private final UsersPasswordService usersPasswordService;

    public UsersSignUpResponse.Create executeSignUp(Create request) {
        usersValidator.validateSignUpRequest(request);
        String encodedPassword = usersPasswordService.encode(request.password());
        Users users = UsersSignUpMapper.INSTANCE.SignUpDTOToUsers(request, encodedPassword);
        usersRepository.save(users);

        return new UsersSignUpResponse.Create(SUCCESS_MESSAGE);
    }
}
