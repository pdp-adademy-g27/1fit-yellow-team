package com.example.onefit.user.role;

import com.example.onefit.common.service.GenericService;
import com.example.onefit.user.permission.PermissionRepository;
import com.example.onefit.user.permission.entity.Permission;
import com.example.onefit.user.role.dto.RoleCreateDto;
import com.example.onefit.user.role.dto.RoleResponseDto;
import com.example.onefit.user.role.dto.RoleUpdateDto;
import com.example.onefit.user.role.entity.Role;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
public class RoleService extends GenericService<Role, UUID, RoleResponseDto, RoleCreateDto, RoleUpdateDto> {
    private final RoleRepository repository;
    private final PermissionRepository permissionRepository;
    private final Class<Role> entityClass = Role.class;
    private final RoleDtoMapper mapper;

    @Override
    protected RoleResponseDto internalCreate(RoleCreateDto roleCreateDto) {
        Role entity = mapper.toEntity(roleCreateDto);
        Set<String> dtoPermissionNames = roleCreateDto.getPermissions();
        Set<Permission> permissions = permissionRepository.findAllByNameIn(dtoPermissionNames);

        if (dtoPermissionNames.size() != permissions.size()) {
            Set<String> permissionNames = permissions.stream().map(Permission::getName).collect(Collectors.toSet());

            dtoPermissionNames.removeAll(permissionNames);
            throw new EntityNotFoundException("Permission with those name are not found. Permission: %s".formatted(dtoPermissionNames));
        }
        entity.setPermissions(permissions);
        entity.setId(UUID.randomUUID());
        Role saved = repository.save(entity);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected RoleResponseDto internalUpdate(UUID uuid, RoleUpdateDto roleUpdateDto) {
        Role role = repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Role with id: %s not found".formatted(uuid)));
        mapper.toEntity(roleUpdateDto, role);

        Role save = repository.save(role);
        return mapper.toResponseDto(save);
    }


    public RoleResponseDto getByName(String name) {
        Role role = repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role with name: %s not found"
                        .formatted(name)));
        return mapper.toResponseDto(role);
    }

}

