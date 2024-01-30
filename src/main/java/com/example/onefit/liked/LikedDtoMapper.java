package com.example.onefit.liked;

import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.liked.dto.LikedCreateDto;
import com.example.onefit.liked.dto.LikedResponseDto;
import com.example.onefit.liked.dto.LikedUpdateDto;
import com.example.onefit.liked.entity.Liked;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikedDtoMapper extends GenericMapper<Liked, LikedCreateDto, LikedResponseDto, LikedUpdateDto> {
   private final ModelMapper modelMapper;

    @Override
    public Liked toEntity(LikedCreateDto likedCreateDto) {
        return modelMapper.map(likedCreateDto,Liked.class);
    }

    @Override
    public LikedResponseDto toResponseDto(Liked liked) {

        return modelMapper.map(liked,LikedResponseDto.class);
    }

    @Override
    public void toEntity(LikedUpdateDto likedUpdateDto, Liked liked){
        modelMapper.map(likedUpdateDto,liked);
    }
}
