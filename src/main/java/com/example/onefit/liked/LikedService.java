package com.example.onefit.liked;

import com.example.onefit.course.CourseRepository;
import com.example.onefit.course.CourseService;
import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.course.entity.Course;
import com.example.onefit.liked.dto.LikedCreateDto;
import com.example.onefit.liked.dto.LikedResponseDto;
import com.example.onefit.liked.entity.Liked;
import com.example.onefit.user.UserRepository;
import com.example.onefit.user.UserService;
import com.example.onefit.user.dto.UserResponseDto;
import com.example.onefit.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class LikedService {

    private final ModelMapper modelMapper;

    private final LikedRepository likedRepository;

    private final UserService userService;

    private final CourseService courseService;


    public LikedResponseDto create_delete(LikedCreateDto likedCreateDto) {
        UUID course = likedCreateDto.getCourse();
        UUID user = likedCreateDto.getUser();
        Optional<Liked> existingLike = likedRepository
                .findByCourse_IdAndAndUser_Id( course , user);


        UserResponseDto existing_user = userService.get(user);

        CourseResponseDto existing_course = courseService.get(course);
        if (existingLike.isPresent()){
              return new LikedResponseDto(existing_user , existing_course ,  "delete") ;
        }
        else {
            Liked entity = modelMapper.map(likedCreateDto, Liked.class);
            likedRepository.save(entity);

            return new LikedResponseDto(existing_user , existing_course , "create") ;
        }
    }


}