package com.example.onefit.facilities;

import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.facilities.dto.FacilitiesCreateDto;
import com.example.onefit.facilities.dto.FacilitiesResponseDto;
import com.example.onefit.facilities.dto.FacilitiesUpdateDto;
import com.example.onefit.facilities.entity.Facilities;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FacilitiesDtoMapper extends GenericMapper<Facilities , FacilitiesCreateDto , FacilitiesResponseDto , FacilitiesUpdateDto> {

    private final ModelMapper mapper;

    @Override
    public Facilities toEntity(FacilitiesCreateDto facilitiesCreateDto) {
        return mapper.map(facilitiesCreateDto , Facilities.class);
    }

    @Override
    public FacilitiesResponseDto toResponseDto(Facilities facilities) {
        FacilitiesResponseDto facilitiesResponseDto = mapper.map(facilities, FacilitiesResponseDto.class);


        return facilitiesResponseDto ;
    }

    @Override
    public void toEntity(FacilitiesUpdateDto facilitiesUpdateDto, Facilities facilities) {
        mapper.map(facilitiesUpdateDto , facilities) ;
    }
}
