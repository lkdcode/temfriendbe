package com.temfriend.backend.module.users.auth.api;

import com.temfriend.backend.global.response.SuccessResponse;
import com.temfriend.backend.global.security.CustomUsersDetail;
import com.temfriend.backend.module.users.auth.dto.request.AuthRequestDTO;
import com.temfriend.backend.module.users.auth.dto.response.AuthResponseDTO;
import com.temfriend.backend.module.users.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("${api.users}")
@RequiredArgsConstructor
public class AuthApiController {
    private final AuthService authService;

    @PostMapping("/log-in")
    public SuccessResponse<AuthResponseDTO.LogIn> getLogIn(
            @RequestBody @Valid AuthRequestDTO.LogIn request
    ) {
        AuthResponseDTO.LogIn response = authService.executeLogIn(request);
        return SuccessResponse.ok(response);
    }

    @PostMapping("/log-out")
    public SuccessResponse<AuthResponseDTO.LogOut> getLogOut(
            @AuthenticationPrincipal CustomUsersDetail customUsersDetail
    ) {
        AuthResponseDTO.LogOut response = authService.executeLogOut(customUsersDetail);
        return SuccessResponse.ok(response);
    }
}