package com.example.onefit.location.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationBaseDto {

    private String name;
    private String latitude;
    private String longitude;


}
