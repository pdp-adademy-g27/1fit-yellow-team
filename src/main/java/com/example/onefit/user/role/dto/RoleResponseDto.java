package com.example.onefit.user.role.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseDto {
    private UUID id;
    private String name;
    private Set<String> permissions;
}
