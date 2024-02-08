package com.example.onefit.rating;

import com.example.onefit.rating.dto.RatingCreateDto;
import com.example.onefit.rating.dto.RatingResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {
    private final RatingService service;

 //   @PreAuthorize("hasAuthority('rating:create')")
    @PostMapping
    public ResponseEntity<RatingResponseDto> create(@RequestBody @Valid RatingCreateDto createDto) {
        RatingResponseDto ratingResponseDto = service.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingResponseDto);
    }

 //   @PreAuthorize("hasAuthority('rating:read')")
//    @GetMapping("/getAll")
//    public Page<RatingResponseDto> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
//        return service.getAll(predicate, pageable);
//    }



}
