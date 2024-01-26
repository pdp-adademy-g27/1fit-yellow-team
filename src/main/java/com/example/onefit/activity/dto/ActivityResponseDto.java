package com.example.onefit.activity.dto;

import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.entity.Course;
import com.example.onefit.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityResponseDto extends ActivityBaseDto {

    private UUID id;

    private Set<CourseResponseDto> courses;

    private Set<User> users;
}
