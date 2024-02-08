package com.example.onefit.location.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocationResponseDto extends LocationBaseDto {
    private UUID id;

    public LocationResponseDto(UUID id ,
        String name, String latitude , String longitude){
        super(name , latitude , longitude);
    }
}
