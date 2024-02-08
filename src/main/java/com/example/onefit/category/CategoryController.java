package com.example.onefit.category;

import com.example.onefit.category.dto.CategoryCreateDto;
import com.example.onefit.category.dto.CategoryResponseDto;
import com.example.onefit.category.dto.CategoryUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {


    private final CategoryService categoryService;

//    @PreAuthorize("hasAuthority('category:create')")
    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryCreateDto createDto){

        CategoryResponseDto responseDto = categoryService.create(createDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

//    @PreAuthorize("hasAuthority('category:read')")
    @GetMapping("/{name}")
    public ResponseEntity<CategoryResponseDto> get(@PathVariable String name){

        CategoryResponseDto responseDto = categoryService.get(name);

        return ResponseEntity.ok(responseDto);
    }

//    @PreAuthorize("hasAuthority('category:read')")
    @GetMapping
    public ResponseEntity<Page<CategoryResponseDto>> get(@RequestParam(required = false) String predicate , Pageable pageable){

        Page<CategoryResponseDto> responseDtos = categoryService.getAll(predicate , pageable);

        return ResponseEntity.ok(responseDtos);
    }

//    @PreAuthorize("hasAuthority('category:update')")
    @PutMapping("/{name}")
    public ResponseEntity<CategoryResponseDto> update(@PathVariable String name , @RequestBody CategoryUpdateDto updateDto){

        CategoryResponseDto update = categoryService.update(name, updateDto);

        return ResponseEntity.ok(update);
    }

//    @PreAuthorize("hasAuthority('category:delete')")
    @DeleteMapping("/{name}")
    public ResponseEntity<CategoryResponseDto> delete(@PathVariable String name){

        categoryService.delete(name);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
