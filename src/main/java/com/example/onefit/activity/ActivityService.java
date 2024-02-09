package com.example.onefit.activity;

import com.example.onefit.activity.dto.ActivityBeginDTO;
import com.example.onefit.activity.dto.ActivityEndDto;
import com.example.onefit.activity.dto.ActivityResponseDto;
import com.example.onefit.activity.dto.ActivityUpdateDto;
import com.example.onefit.activity.entity.Activity;
import com.example.onefit.common.service.GenericService;
import com.example.onefit.subscription.SubscriptionRepository;
import com.example.onefit.subscription.entity.Subscription;
import com.example.onefit.user.UserRepository;
import com.example.onefit.user.dto.UserResponseDto;
import com.example.onefit.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Getter
public class


ActivityService extends GenericService<Activity, UUID, ActivityResponseDto, ActivityBeginDTO, ActivityUpdateDto> {
    private final ActivityRepository repository;
    private final Class<Activity> entityClass=Activity.class;
    private final ActivityMapperDto mapper;
    private  final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    @Override
    protected ActivityResponseDto internalCreate(ActivityBeginDTO activityBeginDTO) {
        User user = userRepository.findUserById(activityBeginDTO.getUser()).orElseThrow(
                () -> new EntityNotFoundException("User not found")
        );

        if(!user.hasValidSubscription()){
             throw  new IllegalArgumentException("You must buy subscription! ") ;
        }

        Integer days = user.getSubscription().getDays();
        Subscription subscription = user.getSubscription();

        if(!isSubscriptionFinished(days , subscription.getStart_time())){
              throw new IllegalArgumentException("Submission already expired") ;
        }

        if(subscription.getStart_time() == null){
            subscription.setStart_time(LocalDateTime.now());
            subscriptionRepository.save(subscription) ;
        }

        Activity entity = new Activity(UUID.randomUUID() , activityBeginDTO.getStartTime() ,
                null , Collections.emptySet() , new HashSet<>(List.of(user)));
        repository.save(entity) ;
        return mapper.toResponseDto(entity);
    }

    private boolean isSubscriptionFinished(Integer subs_days , LocalDateTime start_date ) {
        return start_date.plusDays(subs_days).isBefore(LocalDateTime.now())  ;
    }


    @Override
    protected ActivityResponseDto internalUpdate(UUID uuid, ActivityUpdateDto activityUpdateDto) {
        Activity activity = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        mapper.toEntity(activityUpdateDto,activity);
        repository.save(activity);
        return mapper.toResponseDto(activity);
    }

    public ActivityResponseDto end(ActivityEndDto activityEndDto) {
        Activity activity = repository.findById(activityEndDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("Activity not found exception"));

        activity.setEndTime(LocalDateTime.now());
        repository.save(activity);

        return mapper.toResponseDto(activity);
    }
}
