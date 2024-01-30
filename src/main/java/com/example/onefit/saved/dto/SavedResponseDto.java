package com.example.onefit.saved.dto;

import com.example.onefit.course.entity.Course;
import com.example.onefit.user.entity.User;
import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SavedResponseDto extends SavedDto {
    private UUID id;
    private User users;
    private Course courses;
}
