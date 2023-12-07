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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("${api.users}")
@RequiredArgsConstructor
public class AuthApiController {
    private final AuthService authService;

    @PostMapping("/log-in")
    public SuccessResponse<AuthResponseDTO.LogIn> getLogIn(
            @RequestBody @Valid AuthRequestDTO.LogIn request,
            HttpServletResponse httpServletResponse
    ) {
        AuthResponseDTO.LogIn response = authService.executeLogIn(httpServletResponse, request);
        return SuccessResponse.ok(response);
    }

    @PostMapping("/log-out")
    public SuccessResponse<AuthResponseDTO.LogOut> getLogOut(
            HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse
            , @AuthenticationPrincipal CustomUsersDetail customUsersDetail
    ) {
        AuthResponseDTO.LogOut response = authService.executeLogOut(httpServletRequest, httpServletResponse, customUsersDetail);
        return SuccessResponse.ok(response);
    }
}
