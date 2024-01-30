package com.example.onefit.facilities.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FacilitiesCreateDto {
    @NotBlank
    private String name;

    @NotBlank
    private String image;
}
