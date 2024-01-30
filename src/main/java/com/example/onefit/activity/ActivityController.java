package com.example.onefit.activity;

import com.example.onefit.activity.dto.ActivityCreateDTO;
import com.example.onefit.activity.dto.ActivityResponseDto;
import com.example.onefit.activity.dto.ActivityUpdateDto;
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
    @PreAuthorize(value = "hasAuthority('activity:create')")
    @PostMapping("/addActivity")
    public ResponseEntity<ActivityResponseDto> create(@RequestBody ActivityCreateDTO activityCreateDTO){
        ActivityResponseDto activityResponseDto = activityService.create(activityCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(activityResponseDto);
    }

    @PreAuthorize(value = "hasAuthority('activity:read')")
    @GetMapping("/getAll")
    public Page<ActivityResponseDto> getAll(Pageable pageable,@RequestParam(required = false) String predicate){
        return activityService.getAll(predicate, pageable);
    }

    @PreAuthorize(value = "hasAuthority('activity:read')")
    @GetMapping("/{id}")
    public ActivityResponseDto getId(@PathVariable UUID id){
       return activityService.get(id);
    }

    @PreAuthorize(value = "hasAuthority('activity:update')")
    @PutMapping("/{id}")
    public ActivityResponseDto update(@PathVariable UUID id, @RequestBody ActivityUpdateDto activityUpdateDto){
        return activityService.update(id, activityUpdateDto);
    }

    @PreAuthorize(value = "hasAuthority('activity:delete')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        activityService.delete(id);
    }




}
