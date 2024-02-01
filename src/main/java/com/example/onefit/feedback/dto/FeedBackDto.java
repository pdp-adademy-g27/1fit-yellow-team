package com.example.onefit.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedBackDto {
    private String companyName;
    private String city;
    private String name;
    private String phoneNumber;
    private String email;
    private String instagram;
}
