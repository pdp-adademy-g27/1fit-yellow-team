package com.example.onefit.location;

import com.example.onefit.common.service.GenericService;
import com.example.onefit.facilities.entity.Facilities;
import com.example.onefit.location.dto.LocationCreateDto;
import com.example.onefit.location.dto.LocationResponseDto;
import com.example.onefit.location.dto.LocationUpdateDto;
import com.example.onefit.location.entity.Location;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Getter
@RequiredArgsConstructor
public class LocationService extends GenericService<Location, UUID, LocationResponseDto, LocationCreateDto, LocationUpdateDto> {

    private final LocationRepository repository;
    private final Class<Location> entityClass = Location.class;
    private final LocationDtoMapper mapper;


    @Override
    protected LocationResponseDto internalCreate(LocationCreateDto createDto) {

        Location entity = mapper.toEntity(createDto);

        repository.save(entity);

        return mapper.toResponseDto(entity);
    }

    @Override
    protected LocationResponseDto internalUpdate(UUID id, LocationUpdateDto updateDto) {

        Location location = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Location with id %s not found".formatted(id)));


        mapper.toEntity(updateDto, location);
        Location saved = repository.save(location);
        return mapper.toResponseDto(saved);

    }
}
