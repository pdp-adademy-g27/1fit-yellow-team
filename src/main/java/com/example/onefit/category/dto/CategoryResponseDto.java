package com.example.onefit.category.dto;

import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponseDto  extends CategoryBaseDto{

    private Set<CourseResponseDto> courses;
}
