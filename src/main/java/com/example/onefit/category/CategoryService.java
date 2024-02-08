package com.example.onefit.category;

import com.example.onefit.category.dto.CategoryCreateDto;
import com.example.onefit.category.dto.CategoryResponseDto;
import com.example.onefit.category.dto.CategoryUpdateDto;
import com.example.onefit.category.entity.Category;
import com.example.onefit.common.service.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Getter
@RequiredArgsConstructor
public class CategoryService extends GenericService<Category , String , CategoryResponseDto , CategoryCreateDto , CategoryUpdateDto> {

    private final CategoryRepository repository;
    private final Class<Category> entityClass = Category.class;
    private final CategoryDtoMapper mapper;


    @Override
    protected CategoryResponseDto internalCreate(CategoryCreateDto categoryCreateDto) {

        Category entity = mapper.toEntity(categoryCreateDto);


        repository.save(entity);
        return mapper.toResponseDto(entity);
    }

    @Override
    protected CategoryResponseDto internalUpdate(String s, CategoryUpdateDto categoryUpdateDto) {

        Category category = repository.findById(s).orElseThrow(
                () -> new EntityNotFoundException("Category with name %s not found".formatted(s)));



     ///   mapper.toEntity(categoryUpdateDto, category);
   //     Category newOne = new Category(category.getName() , category.getSmallImage() , category.getBigImage() , category.getCourses()) ;
    //    System.out.println(newOne);


        Category category1 = new Category(categoryUpdateDto.getName() , categoryUpdateDto.getSmallImage() ,
                categoryUpdateDto.getBigImage() , category.getCourses()) ;



        repository.delete(category);

        repository.save(category1);


        return mapper.toResponseDto(category1);
    }
}
