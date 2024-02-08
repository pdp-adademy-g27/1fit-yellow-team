package com.example.onefit.liked.dto;


import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.user.dto.UserResponseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LikedResponseDto {

    @NotBlank
    private UserResponseDto user;

    @NotBlank
    private CourseResponseDto course;

    private String action;
}
