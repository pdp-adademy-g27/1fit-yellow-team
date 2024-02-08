package com.example.onefit.liked.dto;


import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.user.dto.UserResponseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikedCreateDto{

    @NotBlank
    private CourseResponseDto course;

    @NotBlank
    private UserResponseDto user;

}
