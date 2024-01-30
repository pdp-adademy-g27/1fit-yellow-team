package com.example.onefit.activity;

import com.example.onefit.activity.dto.ActivityCreateDto;
import com.example.onefit.activity.dto.ActivityResponseDto;
import com.example.onefit.activity.dto.ActivityUpdateDto;
import com.example.onefit.activity.entity.Activity;
import com.example.onefit.common.mapper.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ActivityDtoMapper extends GenericMapper<Activity, ActivityCreateDto, ActivityResponseDto, ActivityUpdateDto> {
    private final ModelMapper mapper;

    @Override
    public Activity toEntity(ActivityCreateDto createDto) {
        return mapper.map(createDto, Activity.class);
    }

    @Override
    public ActivityResponseDto toResponseDto(Activity activity) {
        ActivityResponseDto responseDto = mapper.map(activity, ActivityResponseDto.class);

        //todo to map users -> UserResponseDto.class

        return responseDto;
    }

    @Override
    public void toEntity(ActivityUpdateDto activityUpdateDto, Activity activity) {
        mapper.map(activityUpdateDto, activity);
    }
}
