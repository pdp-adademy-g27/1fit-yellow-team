package com.example.onefit.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscriptionResponseDto extends SubscriptionDto{
    private UUID id;
}
