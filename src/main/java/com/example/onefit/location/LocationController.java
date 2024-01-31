package com.example.onefit.location;

import com.example.onefit.location.dto.LocationCreateDto;
import com.example.onefit.location.dto.LocationResponseDto;
import com.example.onefit.location.dto.LocationUpdateDto;
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
@RequestMapping("/location")
public class LocationController {
    private final LocationService locationService;

    @PreAuthorize("hasAuthority('location:create')")
    @PostMapping
    public ResponseEntity<LocationResponseDto> create(@RequestBody LocationCreateDto createDto) {

        LocationResponseDto responseDto = locationService.create(createDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PreAuthorize("hasAuthority('location:read')")
    @GetMapping("/{id}")
    public ResponseEntity<LocationResponseDto> get(@PathVariable UUID id) {

        LocationResponseDto responseDto = locationService.get(id);

        return ResponseEntity.ok(responseDto);
    }

    @PreAuthorize("hasAuthority('location:read')")
    @GetMapping
    public ResponseEntity<Page<LocationResponseDto>> get(@RequestParam(required = false) String predicate, Pageable pageable) {

        Page<LocationResponseDto> responseDtos = locationService.getAll(predicate, pageable);

        return ResponseEntity.ok(responseDtos);
    }

    @PreAuthorize("hasAuthority('location:update')")
    @PutMapping("/{id}")
    public ResponseEntity<LocationResponseDto> update(@PathVariable UUID id, @RequestBody LocationUpdateDto updateDto) {

        LocationResponseDto update = locationService.update(id, updateDto);

        return ResponseEntity.ok(update);
    }

    @PreAuthorize("hasAuthority('location:delete')")
    @DeleteMapping("/{id}")
    public ResponseEntity<LocationResponseDto> delete(@PathVariable UUID id) {

        locationService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
