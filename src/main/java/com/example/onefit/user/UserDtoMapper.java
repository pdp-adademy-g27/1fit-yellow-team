package com.example.onefit.user;

import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.user.dto.UserCreateDto;
import com.example.onefit.user.dto.UserResponseDto;
import com.example.onefit.user.dto.UserUpdateDto;
import com.example.onefit.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoMapper extends GenericMapper<User, UserCreateDto, UserResponseDto, UserUpdateDto> {
    private final ModelMapper modelMapper;

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public UserResponseDto toResponseDto(User user) {
        return null;
    }

    @Override
    public UserResponseDto toUpdateEntity(UserUpdateDto userUpdateDto, User user) {
        User map = modelMapper.map(userUpdateDto, User.class);
        return modelMapper.map(map, UserResponseDto.class);
    }

}
