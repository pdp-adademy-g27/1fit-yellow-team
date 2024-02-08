package com.example.onefit.location.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {
    @Id
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

}
