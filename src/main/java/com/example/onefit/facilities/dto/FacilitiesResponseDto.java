package com.example.onefit.facilities.dto;


import com.example.onefit.course.dto.CourseResponseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacilitiesResponseDto {

    @NotBlank
    private String name;

    @NotBlank
    private String image;
    private Set<CourseResponseDto> courses;

}
