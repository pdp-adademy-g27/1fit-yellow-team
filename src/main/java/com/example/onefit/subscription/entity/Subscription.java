package com.example.onefit.subscription.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private Integer days;

    @NotBlank
    private Double price;

    @NotBlank
    private String image;

    private boolean isPopular;
}
