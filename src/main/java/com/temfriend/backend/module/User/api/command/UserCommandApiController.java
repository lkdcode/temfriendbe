package com.temfriend.backend.module.User.api.command;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserCommandApiController {

    @PostMapping("/sign-up")
    public void test1() {
    }

    @PostMapping("/sign-in")
    public void test2() {
    }

    @PostMapping("/logout")
    public void test3() {
    }
}
