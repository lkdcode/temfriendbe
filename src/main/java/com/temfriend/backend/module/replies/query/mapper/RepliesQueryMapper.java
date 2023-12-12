package com.temfriend.backend.module.replies.query.mapper;

import com.temfriend.backend.module.replies.domain.Replies;
import com.temfriend.backend.module.replies.query.dto.response.RepliesQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RepliesQueryMapper {
    RepliesQueryMapper INSTANCE = Mappers.getMapper(RepliesQueryMapper.class);

    @Mapping(target = "nickname", source = "users.profile.nickname")
    RepliesQueryDTO.Get convertGetDTOFrom(Replies replies);

    List<RepliesQueryDTO.Get> convertGetDTOListFrom(List<Replies> repliesList);
}
