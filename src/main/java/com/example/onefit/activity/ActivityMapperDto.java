package com.example.onefit.activity;

import com.example.onefit.activity.dto.ActivityBeginDTO;
import com.example.onefit.activity.dto.ActivityResponseDto;
import com.example.onefit.activity.dto.ActivityUpdateDto;
import com.example.onefit.activity.entity.Activity;
import com.example.onefit.common.mapper.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivityMapperDto extends GenericMapper<Activity, ActivityBeginDTO, ActivityResponseDto, ActivityUpdateDto> {
    private final ModelMapper modelMapper;
    @Override
    public Activity toEntity(ActivityBeginDTO activityBeginDTO) {
        return modelMapper.map(activityBeginDTO,Activity.class);
    }

    @Override
    public ActivityResponseDto toResponseDto(Activity activity) {
        return modelMapper.map(activity, ActivityResponseDto.class);
    }

    @Override
    public void toEntity(ActivityUpdateDto activityUpdateDto, Activity activity) {
     modelMapper.map(activity,activityUpdateDto);
    }
}
