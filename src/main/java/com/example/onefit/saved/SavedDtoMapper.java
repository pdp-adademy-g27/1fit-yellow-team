package com.example.onefit.saved;

import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.saved.dto.SavedCreateDto;
import com.example.onefit.saved.dto.SavedResponseDto;
import com.example.onefit.saved.dto.SavedUpdateDto;
import com.example.onefit.saved.entity.Saved;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SavedDtoMapper extends GenericMapper<Saved, SavedCreateDto, SavedResponseDto, SavedUpdateDto> {
    private final ModelMapper modelMapper;
    @Override
    public Saved toEntity(SavedCreateDto savedCreateDto) {

        return modelMapper.map(savedCreateDto,Saved.class);
    }

    @Override
    public SavedResponseDto toResponseDto(Saved saved) {
        return modelMapper.map(saved,SavedResponseDto.class);
    }

    @Override
    public void toEntity(SavedUpdateDto savedUpdateDto, Saved saved) {
     modelMapper.map(savedUpdateDto,saved);
    }
}
