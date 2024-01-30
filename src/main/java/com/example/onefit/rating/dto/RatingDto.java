package com.example.onefit.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingDto {
    private int star;
    private String comment;
    private UUID course_id;
    private UUID user_id;
}
