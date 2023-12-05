package com.temfriend.backend.module.posts.query.api;

import com.temfriend.backend.global.response.SuccessResponse;
import com.temfriend.backend.module.posts.query.dto.response.PostsQueryResponse;
import com.temfriend.backend.module.posts.query.service.PostsQueryUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;


@RestController
@RequestMapping("${api.posts}")
@RequiredArgsConstructor
public class PostsQueryApiController {
    private final PostsQueryUsecase postsQueryUsecase;

    @GetMapping("/{id}")
    public SuccessResponse<PostsQueryResponse.Get> getFindById(
            @PathVariable(name = "id") @Positive Long id
    ) {
        PostsQueryResponse.Get response = postsQueryUsecase.retrieveSinglePostsById(id);
        return SuccessResponse.ok(response);
    }

    @GetMapping("/writers/{usersId}")
    public SuccessResponse<List<PostsQueryResponse.Get>> getFindByUsersId(
            @PathVariable(name = "usersId") @Positive Long usersId
    ) {
        List<PostsQueryResponse.Get> response = postsQueryUsecase.retrievePostsListByUsersId(usersId);
        return SuccessResponse.ok(response);
    }

    @GetMapping
    public SuccessResponse<List<PostsQueryResponse.Get>> getFindAll(
            @PageableDefault(size = 3, sort = "createdAt", direction = DESC) Pageable pageable
    ) {
        List<PostsQueryResponse.Get> response = postsQueryUsecase.retrievePostsList(pageable);
        return SuccessResponse.ok(response);
    }
}
