package com.example.onefit.activity;

import com.example.onefit.activity.dto.ActivityCreateDTO;
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
@RequiredArgsConstructor
@Getter
public class


ActivityService extends GenericService<Activity, UUID, ActivityResponseDto,ActivityCreateDTO, ActivityUpdateDto> {
    private final ActivityRepository repository;
    private final Class<Activity> entityClass=Activity.class;
    private final ActivityMapperDto mapper;

    @Override
    protected ActivityResponseDto internalCreate(ActivityCreateDTO activityCreateDTO) {
        Activity entity = mapper.toEntity(activityCreateDTO);
        entity.setId(UUID.randomUUID());
//        entity.setStartTime();
//        entity.setEndTime();
        return mapper.toResponseDto(entity);
    }

    @Override
    protected ActivityResponseDto internalUpdate(UUID uuid, ActivityUpdateDto activityUpdateDto) {
        Activity activity = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        mapper.toEntity(activityUpdateDto,activity);
        repository.save(activity);
        return mapper.toResponseDto(activity);
    }
}
