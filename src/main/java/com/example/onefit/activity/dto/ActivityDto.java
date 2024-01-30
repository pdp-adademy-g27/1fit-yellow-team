package com.example.onefit.activity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActivityDto {

    private UUID course_id;
    private UUID user_id;
    private LocalDateTime startTime;

}
