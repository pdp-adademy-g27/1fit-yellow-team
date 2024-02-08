package com.example.onefit.course;

import com.example.onefit.activity.ActivityMapperDto;
import com.example.onefit.activity.dto.ActivityResponseDto;
import com.example.onefit.category.CategoryDtoMapper;
import com.example.onefit.category.dto.CategoryResponseDto;
import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.course.dto.CourseCreateDto;
import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.dto.CourseUpdateDto;
import com.example.onefit.course.entity.Course;
import com.example.onefit.facilities.FacilitiesDtoMapper;
import com.example.onefit.facilities.dto.FacilitiesResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class CourseDtoMapper extends
        GenericMapper<Course , CourseCreateDto , CourseResponseDto , CourseUpdateDto> {
       private final ModelMapper mapper;
       private final FacilitiesDtoMapper facilitiesDtoMapper;
       private final CategoryDtoMapper categoryDtoMapper;
       private final ActivityMapperDto activityDtoMapper;

    @Override
    public Course toEntity(CourseCreateDto courseCreateDto) {
        return mapper.map(courseCreateDto , Course.class);
    }

    @Override
    public CourseResponseDto toResponseDto(Course course) {
        CourseResponseDto courseResponseDto = mapper.map(course, CourseResponseDto.class);


        if(course.getFacilities() != null) {
            Set<FacilitiesResponseDto> facilities = course
                    .getFacilities()
                    .stream()
                    .map(facilitiesDtoMapper::toResponseDto)
                    .collect(Collectors.toSet());

            courseResponseDto.setFacilities(facilities);

        }

        if (course.getCategories() != null) {
            Set<CategoryResponseDto> categories = course
                    .getCategories()
                    .stream()
                    .map(categoryDtoMapper::toResponseDto)
                    .collect(Collectors.toSet());
            courseResponseDto.setCategories(categories);
        }

        if(course.getActivities() != null) {
            Set<ActivityResponseDto> activities = course
                    .getActivities()
                    .stream()
                    .map(activityDtoMapper::toResponseDto)
                    .collect(Collectors.toSet());
            courseResponseDto.setActivities(activities);
        }


      //todo map likeds , saveds  , rating -> responseDto




        return courseResponseDto;
    }

    @Override
    public void toEntity(CourseUpdateDto courseUpdateDto, Course course) {
    mapper.map(courseUpdateDto , course);
    }
}
