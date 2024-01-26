package com.example.onefit.activity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActivityBaseDto {
    @NotBlank
    private LocalDateTime startTime;

    @NotBlank
    private LocalDateTime endTime;


}
