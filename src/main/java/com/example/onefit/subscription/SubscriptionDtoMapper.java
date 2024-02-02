package com.example.onefit.subscription;

import com.example.onefit.common.mapper.GenericMapper;
import com.example.onefit.subscription.dto.SubscriptionCreateDto;
import com.example.onefit.subscription.dto.SubscriptionResponseDto;
import com.example.onefit.subscription.dto.SubscriptionUpdateDto;
import com.example.onefit.subscription.entity.Subscription;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionDtoMapper extends GenericMapper<Subscription, SubscriptionCreateDto, SubscriptionResponseDto, SubscriptionUpdateDto> {

   private final ModelMapper modelmapper;

    @Override
    public Subscription toEntity(SubscriptionCreateDto subscriptionCreateDto) {
        return modelmapper.map(subscriptionCreateDto,Subscription.class);
    }

    @Override
    public SubscriptionResponseDto toResponseDto(Subscription subscription) {
        return modelmapper.map(subscription, SubscriptionResponseDto.class);
    }

    @Override
    public void toEntity(SubscriptionUpdateDto subscriptionUpdateDto, Subscription subscription) {
           modelmapper.map(subscription,subscriptionUpdateDto);
    }
}
