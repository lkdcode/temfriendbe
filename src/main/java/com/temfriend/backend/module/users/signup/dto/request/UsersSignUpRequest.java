package com.temfriend.backend.module.users.signup.dto.request;

import lombok.Builder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.temfriend.backend.module.users.signup.dto.request.UsersSignUpRequest.Create;

public sealed interface UsersSignUpRequest permits Create {
    @Builder
    record Create(
            @Email(message = "이메일을 입력해주세요.")
            @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "올바른 이메일이 아닙니다.")
            String email,
            @NotBlank(message = "비밀번호를 입력해주세요.")
            @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "비밀번호는 8자리 이상 15자리 이하 대문자, 소문자, 특수 문자를 포함해야합니다.")
            String password,
            @NotBlank(message = "재확인 비밀번호를 입력해주세요.")
            @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "비밀번호는 8자리 이상 15자리 이하 대문자, 소문자, 특수 문자를 포함해야합니다.")
            String confirmPassword,
            @NotBlank(message = "이름을 입력해주세요.")
            @Pattern(regexp = "^[가-힣a-zA-Z]+$", message = "이름은 한글 혹은 영어만 가능합니다.")
            String name,
            @NotBlank(message = "닉네임을 입력해주세요.")
            @Pattern(regexp = "^[가-힣a-zA-Z]+$", message = "닉네임은 한글 혹은 영어만 가능합니다.")
            String nickName,
            String img
    ) implements UsersSignUpRequest {
    }
}
