package com.example.onefit.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscriptionResponseDto extends SubscriptionDto{
    private boolean isPopular;
    private UUID id;
}
