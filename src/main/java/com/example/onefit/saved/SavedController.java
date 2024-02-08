package com.example.onefit.saved;

import com.example.onefit.saved.dto.SavedCreateDto;
import com.example.onefit.saved.dto.SavedResponseDto;
import com.example.onefit.saved.dto.SavedUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/saved")
@RequiredArgsConstructor
public class SavedController {
    private final SavedService savedService;
 //   @PreAuthorize(value = "hasAuthority('saved:create')")
    @PostMapping
    public ResponseEntity<SavedResponseDto> create(@RequestBody SavedCreateDto savedCreateDto){
        SavedResponseDto savedResponseDto = savedService.create(savedCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResponseDto);
    }
 //   @PreAuthorize(value = "hasAuthority('saved:read')")
    @GetMapping("/{id}")
    public SavedResponseDto getId(@PathVariable UUID id){
        return savedService.get(id);
    }
 //   @PreAuthorize(value = "hasAuthority('saved:read')")
    @GetMapping("/getAll")
    public Page<SavedResponseDto> getAll(Pageable pageable, @RequestParam(required = false) String predicate){
        return savedService.getAll(predicate, pageable);

    }
 //   @PreAuthorize(value = "hasAuthority('saved:update')")
    @PutMapping("/{id}")
    public SavedResponseDto update(@PathVariable UUID id, @RequestBody SavedUpdateDto savedUpdateDto){
        return savedService.update(id,savedUpdateDto);
    }
 //   @PreAuthorize(value = "hasAuthority('saved:delete')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        savedService.delete(id);
    }
}
