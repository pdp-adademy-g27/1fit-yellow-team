package com.example.onefit.rating;

import com.example.onefit.course.CourseRepository;
import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.entity.Course;
import com.example.onefit.rating.dto.RatingCreateDto;
import com.example.onefit.rating.dto.RatingResponseDto;
import com.example.onefit.rating.entity.Rating;
import com.example.onefit.user.UserRepository;
import com.example.onefit.user.dto.UserResponseDto;
import com.example.onefit.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
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
    private  final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public RatingResponseDto create(RatingCreateDto createDto) {

        Course course  =  courseRepository.findCourseById(createDto.getCourse())
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
        User user = userRepository.findUserById(createDto.getUser())
                .orElseThrow(() ->  new EntityNotFoundException("User not found"));
        Optional<Rating> existingRating = ratingRepository
                .findByCourse_IdAndAndUser_Id(createDto.getCourse(), createDto.getUser());

        if (existingRating.isEmpty()){

            Rating entity = modelMapper.map(createDto , Rating.class) ;

            entity.setId(UUID.randomUUID());
            entity.setUser(user);
            entity.setCourse(course);

            Rating save = ratingRepository.save(entity);
            return  new RatingResponseDto(save.getId() , createDto.getUser() , createDto.getCourse() ,  save.getStar() , "Successfully send"  ) ;
        }


        Rating rating = existingRating.get();
        return  new RatingResponseDto(rating.getId() , createDto.getUser() , createDto.getCourse() , rating.getStar() ,  "You already rate this course") ;
    }
}
