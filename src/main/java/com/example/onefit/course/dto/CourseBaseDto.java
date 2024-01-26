package com.example.onefit.course.dto;


import com.example.onefit.location.entity.Location;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseBaseDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private Location location;

    @NotBlank
    private boolean isFemale;

    @NotBlank
    private List<String> images;

}
