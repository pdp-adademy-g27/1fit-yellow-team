package com.example.onefit.user.dto;

import com.example.onefit.activity.entity.Activity;
import com.example.onefit.liked.entity.*;
import com.example.onefit.rating.entity.Rating;
import com.example.onefit.saved.entity.Saved;
import com.example.onefit.user.permission.entity.Permission;
import com.example.onefit.user.role.entity.Role;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto extends UserBaseDto {
    private UUID id;
    private Set<Role> roles;
    private Set<Permission> permissions;
    private Set<Activity> activities;
    private Set<Rating> ratings;
    private Set<Liked> likeds;
    private Set<Saved> saveds;
    private LocalDateTime created;
    private LocalDateTime updated;
}
