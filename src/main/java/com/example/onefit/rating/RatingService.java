package com.example.onefit.rating;

import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.common.repository.GenericRepository;
import com.example.onefit.common.service.GenericService;
import com.example.onefit.rating.dto.RatingCreateDto;
import com.example.onefit.rating.dto.RatingResponseDto;
import com.example.onefit.rating.dto.RatingUpdateDto;
import com.example.onefit.rating.entity.Rating;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
@Getter
public class RatingService extends GenericService<Rating, UUID, RatingResponseDto, RatingCreateDto, RatingUpdateDto> {
    private final RatingRepository repository;
    private final Class<Rating> entityClass=Rating.class;
    private final RatingDtoMapper mapper;

    @Override
    protected RatingResponseDto internalCreate(RatingCreateDto ratingCreateDto) {
        Rating entity = mapper.toEntity(ratingCreateDto);
        entity.setId(UUID.randomUUID());
        repository.save(entity);
        return mapper.toResponseDto(entity);
    }

    @Override
    protected RatingResponseDto internalUpdate(UUID uuid, RatingUpdateDto ratingUpdateDto) {
        Rating rating = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        mapper.toEntity(ratingUpdateDto,rating);
        Rating save = repository.save(rating);
        return mapper.toResponseDto(save);
    }
}
