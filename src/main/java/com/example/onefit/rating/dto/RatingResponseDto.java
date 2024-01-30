package com.example.onefit.rating.dto;

import com.example.onefit.course.entity.Course;
import com.example.onefit.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingResponseDto extends RatingDto {
    private UUID id;
    private Course course;
    private User user;
}
