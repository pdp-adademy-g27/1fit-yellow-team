package com.example.onefit.rating.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor@NoArgsConstructor
public class RatingCreateDto {

    @Max(10) @Min(0)
    private Integer star;

    private UUID course;
    private UUID user;
    private String comment;
}
