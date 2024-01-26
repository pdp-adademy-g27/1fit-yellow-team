package com.example.onefit.activity;


import com.example.onefit.activity.dto.ActivityCreateDto;
import com.example.onefit.activity.dto.ActivityResponseDto;
import com.example.onefit.activity.dto.ActivityUpdateDto;
import jakarta.validation.Valid;
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
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;

  @PreAuthorize("hasAuthority('activity:create')")
    @PostMapping
    public ResponseEntity<ActivityResponseDto> create(@RequestBody @Valid ActivityCreateDto createDto){

        ActivityResponseDto responseDto = activityService.create(createDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

  @PreAuthorize("hasAuthority('activity:read')")
    @GetMapping("/{id}")
    public ResponseEntity<ActivityResponseDto> get(@PathVariable UUID id){

        ActivityResponseDto responseDto = activityService.get(id);

        return ResponseEntity.ok(responseDto);
    }

    @PreAuthorize("hasAuthority('activity:read')")
    @GetMapping
    public ResponseEntity<Page<ActivityResponseDto>> get(@RequestParam(required = false) String predicate , Pageable pageable){

        Page<ActivityResponseDto> responseDtos = activityService.getAll(predicate , pageable);

        return ResponseEntity.ok(responseDtos);
    }

    @PreAuthorize("hasAuthority('activity:delete')")
    @PutMapping("/{id}")
    public ResponseEntity<ActivityResponseDto> update(@PathVariable UUID id , @RequestBody ActivityUpdateDto updateDto){

        ActivityResponseDto update = activityService.update(id, updateDto);

        return ResponseEntity.ok(update);
    }

    @PreAuthorize("hasAuthority('activity:delete')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ActivityResponseDto> delete(@PathVariable UUID id){

        activityService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
