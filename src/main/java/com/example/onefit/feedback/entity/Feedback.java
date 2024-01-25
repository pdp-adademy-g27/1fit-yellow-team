package com.example.onefit.feedback.entity;

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
public class Feedback {
    @Id
    private UUID id;
    private String companyName;
    private String city;
    private String name;
    private String phoneNumber;
    private String email;
    private String instagram;
}
