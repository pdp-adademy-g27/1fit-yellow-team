package com.example.onefit.course;


import com.example.onefit.common.service.GenericService;
import com.example.onefit.course.dto.CourseCreateDto;
import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.dto.CourseUpdateDto;
import com.example.onefit.course.entity.Course;
import com.example.onefit.location.LocationDtoMapper;
import com.example.onefit.location.LocationRepository;
import com.example.onefit.location.LocationService;
import com.example.onefit.location.entity.Location;
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
    private final LocationRepository locationRepository;
    private final LocationDtoMapper locationDtoMapper;

    @Override
    protected CourseResponseDto internalCreate(CourseCreateDto courseCreateDto) {
        System.out.println(courseCreateDto.getLocation());
        System.out.println(courseCreateDto);

        Location location = locationDtoMapper.toEntity(courseCreateDto.getLocation());
        location.setId(UUID.randomUUID());

        locationRepository.save(location);

        Course entity = mapper.toEntity(courseCreateDto);
        entity.setId(UUID.randomUUID());
        entity.setLocation(location);

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
