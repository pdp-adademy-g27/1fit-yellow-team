package com.example.onefit.category.dto;

import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.entity.Course;

import java.util.Set;



public class CategoryResponseDto  extends CategoryBaseDto{

    private Set<CourseResponseDto> courses;
}
