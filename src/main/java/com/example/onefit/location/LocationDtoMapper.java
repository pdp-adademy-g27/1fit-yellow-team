package com.example.onefit.location;

import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.facilities.dto.FacilitiesCreateDto;
import com.example.onefit.facilities.dto.FacilitiesResponseDto;
import com.example.onefit.facilities.dto.FacilitiesUpdateDto;
import com.example.onefit.facilities.entity.Facilities;
import com.example.onefit.location.dto.LocationCreateDto;
import com.example.onefit.location.dto.LocationResponseDto;
import com.example.onefit.location.dto.LocationUpdateDto;
import com.example.onefit.location.entity.Location;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class LocationDtoMapper extends GenericMapper<Location, LocationCreateDto, LocationResponseDto, LocationUpdateDto> {

    private final ModelMapper mapper;

    @Override
    public Location toEntity(LocationCreateDto locationCreateDto) {
        return mapper.map(locationCreateDto , Location.class);
    }

    @Override
    public LocationResponseDto toResponseDto(Location location) {
        LocationResponseDto responseDto = mapper.map(location, LocationResponseDto.class);


        return responseDto ;
    }

    @Override
    public void toEntity(LocationUpdateDto updateDto, Location location) {
        mapper.map(updateDto , location) ;
    }
}
