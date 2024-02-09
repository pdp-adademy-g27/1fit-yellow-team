package com.example.onefit.facilities;

import com.example.onefit.common.service.GenericService;
import com.example.onefit.facilities.dto.FacilitiesCreateDto;
import com.example.onefit.facilities.dto.FacilitiesResponseDto;
import com.example.onefit.facilities.dto.FacilitiesUpdateDto;
import com.example.onefit.facilities.entity.Facilities;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Getter
@RequiredArgsConstructor
public class FacilitiesService extends GenericService<Facilities , String , FacilitiesResponseDto , FacilitiesCreateDto , FacilitiesUpdateDto> {

    private final FacilitiesRepository repository;
    private final Class<Facilities> entityClass = Facilities.class;
    private final FacilitiesDtoMapper mapper;


    @Override
    protected FacilitiesResponseDto internalCreate(FacilitiesCreateDto facilitiesCreateDto) {

        Facilities entity = mapper.toEntity(facilitiesCreateDto);

        repository.save(entity);

        return mapper.toResponseDto(entity);
    }

    @Override
    protected FacilitiesResponseDto internalUpdate(String name, FacilitiesUpdateDto facilitiesUpdateDto) {

        Facilities facilities = repository.findById(name).orElseThrow(
                () -> new EntityNotFoundException("Facility with name %s not found".formatted(name)));


    //    mapper.toEntity(facilitiesUpdateDto, facilities);


        Facilities facility = new Facilities(facilitiesUpdateDto.getName() , facilitiesUpdateDto.getImage() , facilities.getCourses());

        repository.delete(facilities);

        repository.save(facility) ;

        return mapper.toResponseDto(facility);

    }
}
