package com.example.onefit.activity;


import com.example.onefit.activity.dto.ActivityCreateDto;
import com.example.onefit.activity.dto.ActivityResponseDto;
import com.example.onefit.activity.dto.ActivityUpdateDto;
import com.example.onefit.activity.entity.Activity;
import com.example.onefit.common.service.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class ActivityService  extends GenericService<Activity , UUID , ActivityResponseDto , ActivityCreateDto , ActivityUpdateDto> {

    private final ActivityRepository repository;
    private final Class<Activity> entityClass = Activity.class;
    private final ActivityDtoMapper mapper;

    @Override
    protected ActivityResponseDto internalCreate(ActivityCreateDto activityCreateDto) {


        Activity entity = mapper.toEntity(activityCreateDto);
        entity.setId(UUID.randomUUID());


        repository.save(entity);

        return mapper.toResponseDto(entity);
    }

    @Override
    protected ActivityResponseDto internalUpdate(UUID uuid, ActivityUpdateDto activityUpdateDto) {

        Activity activity = repository.findById(uuid).orElseThrow(
                () -> new EntityNotFoundException("Activity with id %s not found".formatted(uuid)));


        mapper.toEntity(activityUpdateDto, activity);

        Activity saved = repository.save(activity);
        return mapper.toResponseDto(saved);
    }
}
