package com.example.onefit.subscription.entity;

import com.example.onefit.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subscription {
    @Id
    private UUID id;

    private Integer days;

    private Double price;

    @NotBlank
    private String image;

    private boolean isPopular;

    @OneToMany(mappedBy = "subscription")
    private List<User> users;

    private LocalDateTime start_time;
}
