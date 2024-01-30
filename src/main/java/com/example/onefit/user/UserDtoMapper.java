package com.example.onefit.user;

import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.user.dto.UserCreateDto;
import com.example.onefit.user.dto.UserResponseDto;
import com.example.onefit.user.dto.UserUpdateDto;
import com.example.onefit.user.entity.User;
import com.example.onefit.user.permission.entity.Permission;
import com.example.onefit.user.role.RoleDtoMapper;
import com.example.onefit.user.role.dto.RoleResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserDtoMapper extends GenericMapper<User, UserCreateDto, UserResponseDto, UserUpdateDto> {
    private final ModelMapper modelMapper;
    private final RoleDtoMapper roleDtoMapper;

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return modelMapper.map(userCreateDto, User.class);
    }

    @Override
    public UserResponseDto toResponseDto(User user) {
        UserResponseDto responseDto = modelMapper.map(user, UserResponseDto.class);

        Set<RoleResponseDto> roles = user
                .getRoles()
                .stream()
                .map(roleDtoMapper::toResponseDto)
                .collect(Collectors.toSet());

        Set<String> permissions = user
                .getPermissions()
                .stream()
                .map(Permission::getName)
                .collect(Collectors.toSet());

        responseDto.setPermissions(permissions);
        responseDto.setRoles(roles);

        return responseDto;

    }

    @Override
    public void toEntity(UserUpdateDto userUpdateDto, User user) {
        modelMapper.map(userUpdateDto, user);
    }

}
