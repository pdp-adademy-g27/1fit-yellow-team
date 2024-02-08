package com.example.onefit.liked;

import com.example.onefit.course.dto.CourseResponseDto;
import com.example.onefit.liked.dto.LikedCreateDto;
import com.example.onefit.liked.dto.LikedResponseDto;
import com.example.onefit.liked.entity.Liked;
import com.example.onefit.user.dto.UserResponseDto;
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


    public LikedResponseDto create_delete(LikedCreateDto likedCreateDto) {
        CourseResponseDto course = likedCreateDto.getCourse();
        UserResponseDto user = likedCreateDto.getUser();
        Optional<Liked> existingLike = likedRepository
                .findByCourse_IdAndAndUser_Id(course.getId() , user.getId());


        if (existingLike.isPresent()){
              return new LikedResponseDto(user , course ,  "delete") ;
        }
        else {
            Liked entity = modelMapper.map(likedCreateDto, Liked.class);
            likedRepository.save(entity);

            return new LikedResponseDto(user , course , "create") ;
        }
    }


}