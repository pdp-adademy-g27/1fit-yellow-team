package com.example.onefit.saved.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SavedDto {
    private UUID course_id;
    private UUID user_id;
}
