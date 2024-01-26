package com.example.onefit.facilities;

import com.example.onefit.facilities.dto.FacilitiesCreateDto;
import com.example.onefit.facilities.dto.FacilitiesResponseDto;
import com.example.onefit.facilities.dto.FacilitiesUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/facilities")
public class FacilitiesController {


    private final FacilitiesService facilitiesService;

    @PreAuthorize("hasAuthority('facilities:create')")
    @PostMapping
    public ResponseEntity<FacilitiesResponseDto> create(@RequestBody FacilitiesCreateDto createDto){

        FacilitiesResponseDto responseDto = facilitiesService.create(createDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

   @PreAuthorize("hasAuthority('facilities:read')")
    @GetMapping("/{name}")
    public ResponseEntity<FacilitiesResponseDto> get(@PathVariable String name){

        FacilitiesResponseDto responseDto = facilitiesService.get(name);

        return ResponseEntity.ok(responseDto);
    }

    @PreAuthorize("hasAuthority('facilities:read')")
    @GetMapping
    public ResponseEntity<Page<FacilitiesResponseDto>> get(@RequestParam(required = false) String predicate , Pageable pageable){

        Page<FacilitiesResponseDto> responseDtos = facilitiesService.getAll(predicate , pageable);

        return ResponseEntity.ok(responseDtos);
    }

  @PreAuthorize("hasAuthority('facilities:update')")
    @PutMapping("/{name}")
    public ResponseEntity<FacilitiesResponseDto> update(@PathVariable String name , @RequestBody FacilitiesUpdateDto updateDto){

        FacilitiesResponseDto update = facilitiesService.update(name, updateDto);

        return ResponseEntity.ok(update);
    }

  @PreAuthorize("hasAuthority('facilities:delete')")
    @DeleteMapping("/{name}")
    public ResponseEntity<FacilitiesResponseDto> delete(@PathVariable String name){

        facilitiesService.delete(name);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
