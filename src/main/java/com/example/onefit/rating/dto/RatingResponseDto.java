package com.example.onefit.rating.dto;

import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.entity.Course;
import com.example.onefit.user.dto.UserResponseDto;
import com.example.onefit.user.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingResponseDto extends RatingDto {

    @NotBlank
    private UUID id;

    @NotBlank
    private UserResponseDto user;

    @NotBlank
    private CourseResponseDto course;
    private String message;
}
