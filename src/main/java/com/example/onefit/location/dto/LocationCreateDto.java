package com.example.onefit.location.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class LocationCreateDto extends LocationBaseDto {

    public LocationCreateDto(String name , String latitude , String longitude) {
      super(name, latitude, longitude);
    }
}
