package com.example.onefit.liked.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikedCreateDto{

    @NotBlank
    private UUID course;

    @NotBlank
    private UUID user;

}
