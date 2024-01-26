package com.example.onefit.category.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryBaseDto {

    @NotBlank
    private String name;

    @NotBlank
    private String smallImage;

    @NotBlank
    private String bigImage;
}
