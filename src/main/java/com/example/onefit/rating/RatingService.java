package com.example.onefit.rating;

import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.entity.Course;
import com.example.onefit.rating.dto.RatingCreateDto;
import com.example.onefit.rating.dto.RatingResponseDto;
import com.example.onefit.rating.entity.Rating;
import com.example.onefit.user.dto.UserResponseDto;
import com.example.onefit.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
@Getter
public class RatingService {
    private final ModelMapper modelMapper;
    private final RatingRepository ratingRepository;

    public RatingResponseDto create(RatingCreateDto createDto) {

        CourseResponseDto course = createDto.getCourse() ;
        UserResponseDto user = createDto.getUser();
        Optional<Rating> existingRating = ratingRepository
                .findByCourse_IdAndAndUser_Id(course.getId(), user.getId());

        if (existingRating.isEmpty()){

            Rating entity = modelMapper.map(createDto , Rating.class) ;

            entity.setId(UUID.randomUUID());

            Rating save = ratingRepository.save(entity);
            return  new RatingResponseDto(save.getId() , user , course , "Successfully send") ;
        }


        Rating rating = existingRating.get();
        return  new RatingResponseDto(rating.getId() , user , course , "You already rate this course") ;
    }
}
