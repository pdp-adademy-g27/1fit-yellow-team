package com.example.onefit.course;

import com.example.onefit.course.dto.CourseCreateDto;
import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.dto.CourseUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {


    private final CourseService courseService;

    @PreAuthorize("hasAuthority('course:create')")
    @PostMapping
    public ResponseEntity<CourseResponseDto> create(@RequestBody CourseCreateDto createDto){

        CourseResponseDto responseDto = courseService.create(createDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

   @PreAuthorize("hasAuthority('course:read')")
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> get(@PathVariable UUID id){

        CourseResponseDto responseDto = courseService.get(id);

        return ResponseEntity.ok(responseDto);
    }

   @PreAuthorize("hasAuthority('course:read')")
    @GetMapping
    public ResponseEntity<Page<CourseResponseDto>> get(@RequestParam(required = false) String predicate , Pageable pageable){

        Page<CourseResponseDto> responseDtos = courseService.getAll(predicate , pageable);

        return ResponseEntity.ok(responseDtos);
    }

   @PreAuthorize("hasAuthority('course:update')")
    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDto> update(@PathVariable UUID id , @RequestBody CourseUpdateDto updateDto){

        CourseResponseDto update = courseService.update(id, updateDto);

        return ResponseEntity.ok(update);
    }

  @PreAuthorize("hasAuthority('course:delete')")
    @DeleteMapping("/{id}")
    public ResponseEntity<CourseResponseDto> delete(@PathVariable UUID id){

        courseService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
