package com.example.onefit.feedback;

import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.feedback.dto.FeedBackCreateDto;
import com.example.onefit.feedback.dto.FeedBackResponseDto;
import com.example.onefit.feedback.dto.FeedBackUpdateDto;
import com.example.onefit.feedback.entity.Feedback;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedBackDtoMapper extends GenericMapper<Feedback, FeedBackCreateDto, FeedBackResponseDto, FeedBackUpdateDto> {
    private final ModelMapper modelMapper;
    @Override
    public Feedback toEntity(FeedBackCreateDto feedBackCreateDto) {
        return modelMapper.map(feedBackCreateDto, Feedback.class);
    }

    @Override
    public FeedBackResponseDto toResponseDto(Feedback feedback) {
        return modelMapper.map(feedback, FeedBackResponseDto.class);
    }

    @Override
    public void toEntity(FeedBackUpdateDto feedBackUpdateDto, Feedback feedback) {
       modelMapper.map(feedBackUpdateDto,feedback);
    }
}
