package com.example.onefit.subscription;

import com.example.onefit.subscription.dto.SubscriptionCreateDto;
import com.example.onefit.subscription.dto.SubscriptionResponseDto;
import com.example.onefit.subscription.dto.SubscriptionUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequiredArgsConstructor
@RequestMapping("subscription")
public class SubscriptionController {
 private final SubscriptionService service;
 //   @PreAuthorize(value = "hasAuthority('subscription:create')")
    @PostMapping
    public ResponseEntity<SubscriptionResponseDto> create (@RequestBody SubscriptionCreateDto createDto){
        SubscriptionResponseDto subscriptionResponseDto = service.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionResponseDto);
    }

 //   @PreAuthorize(value = "hasAuthority('subscription:read')")
    @GetMapping("/{id}")
    public SubscriptionResponseDto getId(@PathVariable UUID id){
        return service.get(id);
    }

 //   @PreAuthorize(value = "hasAuthority('subscription:read')")
    @GetMapping("/getAll")
    public Page<SubscriptionResponseDto> getAll(Pageable pageable, @RequestParam(required = false) String predicate){
        return service.getAll(predicate, pageable);

    }
 //   @PreAuthorize(value = "hasAuthority('subscription:update')")
    @PutMapping("/{id}")
    public SubscriptionResponseDto update(@PathVariable UUID id, @RequestBody SubscriptionUpdateDto subscriptionUpdateDto){
        return service.update(id,subscriptionUpdateDto);
    }

 //   @PreAuthorize(value = "hasAuthority('subscription:delete')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }

}
