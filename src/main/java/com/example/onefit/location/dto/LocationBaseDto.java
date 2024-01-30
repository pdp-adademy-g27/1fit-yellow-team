package com.example.onefit.location.dto;


import com.example.onefit.course.entity.Course;
import com.example.onefit.location.entity.Location;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationBaseDto {

    private String name;
    private String latitude;
    private String longitude;


}
