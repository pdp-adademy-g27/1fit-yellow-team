package com.example.onefit.saved;

import com.example.onefit.common.service.GenericService;
import com.example.onefit.saved.dto.SavedCreateDto;
import com.example.onefit.saved.dto.SavedResponseDto;
import com.example.onefit.saved.dto.SavedUpdateDto;
import com.example.onefit.saved.entity.Saved;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Getter
@RequiredArgsConstructor
public class SavedService extends GenericService<Saved, UUID, SavedResponseDto, SavedCreateDto, SavedUpdateDto> {
    private final SavedRepository repository;
    private final Class<Saved> entityClass= Saved.class;
    private final SavedDtoMapper mapper;

    @Override
    protected SavedResponseDto internalCreate(SavedCreateDto savedCreateDto) {
        Saved entity = mapper.toEntity(savedCreateDto);
        entity.setId(UUID.randomUUID());
        Saved save = repository.save(entity);
        return mapper.toResponseDto(save);
    }

    @Override
    protected SavedResponseDto internalUpdate(UUID uuid, SavedUpdateDto savedUpdateDto) {
        Saved saved = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        mapper.toEntity(savedUpdateDto,saved);
        repository.save(saved);
        return mapper.toResponseDto(saved);
    }
}
