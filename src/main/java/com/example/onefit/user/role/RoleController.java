package com.example.onefit.user.role;

import com.example.onefit.user.role.dto.RoleCreateDto;
import com.example.onefit.user.role.dto.RoleResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody @Valid RoleCreateDto roleCreateDto) {
        RoleResponseDto responseDto = roleService.create(roleCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<RoleResponseDto>> getRoles(@RequestParam(required = false) String predicate, Pageable pageable) {
        Page<RoleResponseDto> roleResponseDTOS = roleService.getAll(predicate, pageable);
        return ResponseEntity.ok(roleResponseDTOS);
    }

    @GetMapping("/{name}")
    public ResponseEntity<RoleResponseDto> getRole(@PathVariable String name) {
        RoleResponseDto roleResponseDTOS = roleService.getByName(name);
        return ResponseEntity.ok(roleResponseDTOS);
    }
}
