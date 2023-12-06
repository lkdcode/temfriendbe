package com.temfriend.backend.module.posts.command.mapper.response;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostsResponseMapper {
    PostsResponseMapper INSTANCE = Mappers.getMapper(PostsResponseMapper.class);
}
