package com.example.onefit.course;


import com.example.onefit.common.service.GenericService;
import com.example.onefit.course.dto.CourseCreateDto;
import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.dto.CourseUpdateDto;
import com.example.onefit.course.entity.Course;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Getter
@RequiredArgsConstructor
public class CourseService extends
        GenericService<Course, UUID , CourseResponseDto , CourseCreateDto , CourseUpdateDto> {

    private final CourseRepository repository;
    private final Class<Course> entityClass = Course.class;
    private final CourseDtoMapper mapper;

    @Override
    protected CourseResponseDto internalCreate(CourseCreateDto courseCreateDto) {

        Course entity = mapper.toEntity(courseCreateDto);

        entity.setId(UUID.randomUUID());
        repository.save(entity);

        return mapper.toResponseDto(entity);
    }

    @Override
    protected CourseResponseDto internalUpdate(UUID uuid, CourseUpdateDto courseUpdateDto) {

        Course course = repository.findById(uuid).orElseThrow(
                () -> new EntityNotFoundException("Course with id %s not found".formatted(uuid)));


        mapper.toEntity(courseUpdateDto, course);

        Course saved = repository.save(course);
        return mapper.toResponseDto(saved);
    }
}
