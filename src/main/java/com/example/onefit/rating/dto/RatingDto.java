package com.example.onefit.rating.dto;

import com.example.onefit.course.dto.CourseCreateDto;
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
public class RatingDto {

    @NotBlank
    private int star;
    private String comment;
    private CourseResponseDto course;
    private UserResponseDto user;
}
