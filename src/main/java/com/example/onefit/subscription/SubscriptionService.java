package com.example.onefit.subscription;

import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.common.repository.GenericRepository;
import com.example.onefit.common.service.GenericService;
import com.example.onefit.subscription.dto.SubscriptionCreateDto;
import com.example.onefit.subscription.dto.SubscriptionResponseDto;
import com.example.onefit.subscription.dto.SubscriptionUpdateDto;
import com.example.onefit.subscription.entity.Subscription;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Getter
@RequiredArgsConstructor
public class SubscriptionService extends GenericService<Subscription, UUID, SubscriptionResponseDto, SubscriptionCreateDto, SubscriptionUpdateDto> {

    private final SubscriptionRepository repository;
    private final Class<Subscription> entityClass = Subscription.class;
    private final SubscriptionDtoMapper mapper;

    @Override
    protected SubscriptionResponseDto internalCreate(SubscriptionCreateDto subscriptionCreateDto) {
        Subscription entity = mapper.toEntity(subscriptionCreateDto);
        entity.setId(UUID.randomUUID());
        repository.save(entity);
        return mapper.toResponseDto(entity);
    }

    @Override
    protected SubscriptionResponseDto internalUpdate(UUID uuid, SubscriptionUpdateDto subscriptionUpdateDto) {
        Subscription subscription = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        mapper.toEntity(subscriptionUpdateDto,subscription);
        Subscription save = repository.save(subscription);
        return mapper.toResponseDto(save);

    }
}
