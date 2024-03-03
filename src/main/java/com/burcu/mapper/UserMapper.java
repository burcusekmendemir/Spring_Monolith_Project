package com.burcu.mapper;

import com.burcu.dto.request.UserRegisterRequestDto;
import com.burcu.dto.response.UserRegisterResponseDto;
import com.burcu.entiy.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    User fromUserRegisterDtoToUser(final UserRegisterRequestDto dto);


    UserRegisterResponseDto fromUserToUserRegisterResponseDto(User user);
}
