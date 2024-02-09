package com.example.onefit.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignInDto {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String password;
}
