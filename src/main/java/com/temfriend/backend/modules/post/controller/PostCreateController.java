package com.temfriend.backend.modules.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
public class PostCreateController extends PostController {
    @GetMapping("/test")
    public void test() {
        System.out.println("hello world");
    }

}
