package com.temfriend.backend.modules.post.service.post;

import com.temfriend.backend.modules.post.domain.Post;

import java.util.List;

public interface PostReadService {
    List<Post> getPostList();

    Post getPost(Post post);

}
