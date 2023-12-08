package com.temfriend.backend.module.replies.command.mapper.response;

import com.temfriend.backend.module.replies.command.dto.request.RepliesRequestDTO;
import com.temfriend.backend.module.replies.domain.Replies;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepliesResponseMapper {
    RepliesResponseMapper INSTANCE = Mappers.getMapper(RepliesResponseMapper.class);

    RepliesRequestDTO.Create convertCreateDTOFrom(Replies replies);

    RepliesRequestDTO.Update convertUpdateDTOFrom(Replies replies);
}
