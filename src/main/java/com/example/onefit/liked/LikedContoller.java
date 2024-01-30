package com.example.onefit.liked;

import com.example.onefit.liked.dto.LikedCreateDto;
import com.example.onefit.liked.dto.LikedResponseDto;
import com.example.onefit.liked.dto.LikedUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/liked")
@RequiredArgsConstructor
public class LikedContoller{
    private final LikedService likedService;
//    @PreAuthorize(value = "hasAuthority('liked:create')")
    @PostMapping("/addLike")
    public ResponseEntity<LikedResponseDto> create(@RequestBody LikedCreateDto likedCreateDto){
        LikedResponseDto likedResponseDto = likedService.create(likedCreateDto);
        System.out.println(likedResponseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(likedResponseDto);
    }

 //   @PreAuthorize(value = "hasAuthority('liked:read')")
    @GetMapping("/{id}")
    public LikedResponseDto getId(@PathVariable UUID id){
     return likedService.get(id);
    }

    @PreAuthorize(value = "hasAuthority('liked:read')")
    @GetMapping("/getAll")
    public Page<LikedResponseDto> getAll(Pageable pageable, @RequestParam(required = false) String predicate){
        return likedService.getAll(predicate, pageable);

    }
 //   @PreAuthorize(value = "hasAuthority('liked:update')")
    @PutMapping("/{id}")
    public LikedResponseDto update(@PathVariable UUID id, @RequestBody LikedUpdateDto likedUpdateDto){
        return likedService.update(id,likedUpdateDto);
    }

   // @PreAuthorize(value = "hasAuthority('liked:delete')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        likedService.delete(id);
    }















//    @PostMapping("addLike")
//    public ResponseEntity<LikedResponseDto> create(@RequestBody LikedCreateDto createDto){
//        LikedResponseDto likedResponseDto = likedService.create(createDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(likedResponseDto);
//    }

}
