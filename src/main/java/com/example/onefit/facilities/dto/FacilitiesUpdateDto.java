package com.example.onefit.facilities.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacilitiesUpdateDto {

    @NotBlank
    private String name;

    @NotBlank
    private String image;
}
