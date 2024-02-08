package com.example.onefit.course.dto;

import com.example.onefit.location.dto.LocationCreateDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class CourseCreateDto extends CourseBaseDto{
      public CourseCreateDto(String name , String description ,  LocationCreateDto location , boolean isFemale , List<String> images ) {
          super(name , description , location , isFemale , images) ;
    }
}
