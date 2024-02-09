package com.example.onefit.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscriptionDto {
    private LocalDateTime days;
    private Double price;
    private String image;
}
