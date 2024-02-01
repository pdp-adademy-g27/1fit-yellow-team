package com.example.onefit.feedback;

import com.example.onefit.feedback.dto.FeedBackCreateDto;
import com.example.onefit.feedback.dto.FeedBackResponseDto;
import com.example.onefit.feedback.dto.FeedBackUpdateDto;
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
@RequestMapping("/feedback")
public class FeedBackController {
    private final FeedBackService feedBackService;
    @PreAuthorize(value = "hasAuthority('feedback:create')")
    @PostMapping("/create")
    public ResponseEntity<FeedBackResponseDto> create (@RequestBody FeedBackCreateDto createDto){
        FeedBackResponseDto feedBackResponseDto = feedBackService.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedBackResponseDto);
    }

    @PreAuthorize(value = "hasAuthority('feedback:read')")
    @GetMapping("/{id}")
    public FeedBackResponseDto getId(@PathVariable UUID id){
        return feedBackService.get(id);
    }

    @PreAuthorize(value = "hasAuthority('feedback:read')")
    @GetMapping("/getAll")
    public Page<FeedBackResponseDto> getAll(Pageable pageable, @RequestParam(required = false) String predicate){
        return feedBackService.getAll(predicate, pageable);

    }
       @PreAuthorize(value = "hasAuthority('feedback:update')")
    @PutMapping("/{id}")
    public FeedBackResponseDto update(@PathVariable UUID id, @RequestBody FeedBackUpdateDto feedBackUpdateDto){
        return feedBackService.update(id,feedBackUpdateDto);
    }

     @PreAuthorize(value = "hasAuthority('feedback:delete')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        feedBackService.delete(id);
    }

}
