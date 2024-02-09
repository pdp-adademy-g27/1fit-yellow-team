package com.example.onefit.rating.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingResponseDto {

    @NotBlank
    private UUID id;

    @NotBlank
    private UUID user;

    @NotBlank
    private UUID course;

    @Max(10) @Min(0)
    private Integer star;

    private String comment;

}
