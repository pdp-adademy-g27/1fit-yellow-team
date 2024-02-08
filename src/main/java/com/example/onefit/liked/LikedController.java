package com.example.onefit.liked;

import com.example.onefit.liked.dto.LikedCreateDto;
import com.example.onefit.liked.dto.LikedResponseDto;
import com.example.onefit.liked.entity.Liked;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/liked")
@RequiredArgsConstructor
public class LikedController {
    private final LikedService likedService;

    //   @PreAuthorize(value = "hasAuthority('liked:create')")
    @PostMapping
    public ResponseEntity<LikedResponseDto> create_delete(@RequestBody LikedCreateDto likedCreateDto) {

        LikedResponseDto likedResponseDto = likedService
                .create_delete
                (likedCreateDto);


        return ResponseEntity.status(HttpStatus.CREATED).body(likedResponseDto);
    }

}


