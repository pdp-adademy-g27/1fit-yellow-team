package com.example.onefit.common.mapper;


import com.example.onefit.user.role.dto.RoleResponseDto;

public abstract class GenericMapper<ENTITY, CREATE_DTO, RESPONSE_DTO, UPDATE_DTO> {
    public abstract ENTITY toEntity(CREATE_DTO createDto);

    public abstract RESPONSE_DTO toResponseDto(ENTITY entity);

    public abstract RESPONSE_DTO toUpdateEntity(UPDATE_DTO updateDto, ENTITY entity);
}
