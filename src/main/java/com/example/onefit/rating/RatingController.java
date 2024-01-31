package com.example.onefit.rating;

import com.example.onefit.rating.dto.RatingCreateDto;
import com.example.onefit.rating.dto.RatingResponseDto;
import com.example.onefit.rating.dto.RatingUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {
    private final RatingService service;

    @PreAuthorize("hasAuthority('rating:create')")
    @PostMapping("/addRating")
    public ResponseEntity<RatingResponseDto> create(@RequestBody RatingCreateDto createDto) {
        RatingResponseDto ratingResponseDto = service.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingResponseDto);
    }

    @PreAuthorize("hasAuthority('rating:read')")
    @GetMapping("/getAll")
    public Page<RatingResponseDto> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
        return service.getAll(predicate, pageable);
    }

    @PreAuthorize("hasAuthority('rating:read')")
    @GetMapping("/{id}")
    public RatingResponseDto get(@PathVariable UUID id) {
        return service.get(id);
    }

    @PreAuthorize("hasAuthority('rating:update')")
    @PutMapping("/{id}")
    public RatingResponseDto update(@PathVariable UUID id, @RequestBody RatingUpdateDto updateDto) {
        return service.update(id, updateDto);
    }

    @PreAuthorize(value = "hasAuthority('rating:delete')")
    @DeleteMapping("/{Id}")
    public void delete(@PathVariable UUID uuid) {
        service.delete(uuid);
    }

}
