package com.temfriend.backend.module.users.signup.service;

import com.temfriend.backend.module.users.common.service.UsersValidator;
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
    private final UsersRepository usersRepository;
    private final UsersValidator usersValidator;

    public UsersSignUpResponse.Create executeSignup(Create request) {
        usersValidator.validateSignupRequest(request);
        usersRepository.save(UsersSignUpMapper.INSTANCE
                .SignUpDTOToUser(request));

        return new UsersSignUpResponse.Create("회원가입에 성공했습니다.");
    }
}
