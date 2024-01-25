package com.example.onefit.subscription.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subscription {
    @Id
    private UUID id;
    private String days;
    private String freezingDays;
    private String price;
    private String image;
    private boolean isPopular;
}
