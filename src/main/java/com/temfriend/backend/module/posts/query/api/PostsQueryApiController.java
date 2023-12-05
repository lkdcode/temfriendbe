package com.temfriend.backend.module.posts.query.api;

import com.temfriend.backend.global.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.posts}")
public class PostsQueryApiController {

    @GetMapping
    public SuccessResponse<?> getFindAll(
    ) {

        return SuccessResponse.ok(null);
    }

    @GetMapping("/{id}")
    public SuccessResponse<?> getFindById(
            @PathVariable(name = "id") Long id
    ) {

        return SuccessResponse.ok(null);
    }
}
