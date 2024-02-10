package com.example.onefit.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSubscriptionBuy {

    private UUID userId;
    private UUID subscriptionId;
}
