package com.example.onefit.feedback;

import com.example.onefit.common.service.GenericService;
import com.example.onefit.feedback.dto.FeedBackCreateDto;
import com.example.onefit.feedback.dto.FeedBackResponseDto;
import com.example.onefit.feedback.dto.FeedBackUpdateDto;
import com.example.onefit.feedback.entity.Feedback;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
@Getter
public class FeedBackService extends GenericService<Feedback, UUID, FeedBackResponseDto, FeedBackCreateDto,FeedBackUpdateDto> {

    private final FeedBackRepository repository;
    private final Class<Feedback> entityClass=Feedback.class;
    private final FeedBackDtoMapper mapper;


    @Override
    protected FeedBackResponseDto internalCreate(FeedBackCreateDto feedBackCreateDto) {
        Feedback entity = mapper.toEntity(feedBackCreateDto);
        entity.setId(UUID.randomUUID());
        Feedback save = repository.save(entity);
        return mapper.toResponseDto(save);
    }

    @Override
    protected FeedBackResponseDto internalUpdate(UUID uuid, FeedBackUpdateDto updateDto) {
        Feedback feedback = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        mapper.toEntity(updateDto,feedback);
        repository.save(feedback);
        return mapper.toResponseDto(feedback);

    }
}
