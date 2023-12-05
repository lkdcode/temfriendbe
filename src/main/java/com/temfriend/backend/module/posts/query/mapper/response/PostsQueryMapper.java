package com.temfriend.backend.module.posts.query.mapper.response;

import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.posts.query.dto.response.PostsQueryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostsQueryMapper {

    PostsQueryMapper INSTANCE = Mappers.getMapper(PostsQueryMapper.class);

    PostsQueryResponse.Get createResponseGetFrom(Posts posts);

    List<PostsQueryResponse.Get> createListResponseGetFrom(List<Posts> postsList);
}
