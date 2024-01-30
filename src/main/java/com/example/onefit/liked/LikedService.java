package com.example.onefit.liked;

import com.example.onefit.common.service.GenericService;
import com.example.onefit.liked.dto.LikedCreateDto;
import com.example.onefit.liked.dto.LikedResponseDto;
import com.example.onefit.liked.dto.LikedUpdateDto;
import com.example.onefit.liked.entity.Liked;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class LikedService extends GenericService<Liked,UUID,LikedResponseDto,LikedCreateDto, LikedUpdateDto> {
    private final LikedRepository repository;
    private final Class<Liked> entityClass=Liked.class;
    private final LikedDtoMapper mapper;

    @Override
    protected LikedResponseDto internalCreate(LikedCreateDto likedCreateDto) {
        Liked entity = mapper.toEntity(likedCreateDto);
;        entity.setId(UUID.randomUUID());
        Liked saved = repository.save(entity);
        System.out.println("saved = " + saved);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected LikedResponseDto internalUpdate(UUID uuid, LikedUpdateDto likedUpdateDto) {
        Liked liked = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        mapper.toEntity(likedUpdateDto,liked);
        repository.save(liked);
        return mapper.toResponseDto(liked);


    }

//    public LikedResponseDto create(LikedCreateDto createDto) {
//        Liked liked = modelMapper.map(createDto, Liked.class);
//        liked.setId(UUID.randomUUID());
//        likedRepository.save(liked);
//        return modelMapper.map(liked,LikedResponseDto.class);
//    }
//
//    public List<LikedResponseDto> getAll(){
//        List<Liked> liked = likedRepository.findAll();
//        LikedResponseDto likedResponseDto = modelMapper.map(liked, LikedResponseDto.class);
//        return (List<LikedResponseDto>) likedResponseDto;
//    }
}
