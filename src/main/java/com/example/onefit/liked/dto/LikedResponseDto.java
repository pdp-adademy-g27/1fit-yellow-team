package com.example.onefit.liked.dto;

import com.example.onefit.course.entity.Course;
import com.example.onefit.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@EqualsAndHashCode(callSuper = true)
public class LikedResponseDto {
    private UUID id;
    private UUID course_id;
    private UUID user_id;
    private User users;
    private Course courses;
}
