package com.example.onefit.activity.dto;

import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.user.dto.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActivityDto {

    private CourseResponseDto course;
    private UserResponseDto user;
    private LocalDateTime startTime;

}
