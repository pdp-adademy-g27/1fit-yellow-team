package com.example.onefit.category;

import com.example.onefit.category.dto.CategoryCreateDto;
import com.example.onefit.category.dto.CategoryResponseDto;
import com.example.onefit.category.dto.CategoryUpdateDto;
import com.example.onefit.category.entity.Category;
import com.example.onefit.common.mapper.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CategoryDtoMapper extends GenericMapper<Category , CategoryCreateDto , CategoryResponseDto , CategoryUpdateDto> {

    private final ModelMapper mapper;

    @Override
    public Category toEntity(CategoryCreateDto categoryCreateDto) {
        return mapper.map(categoryCreateDto , Category.class);
    }

    @Override
    public CategoryResponseDto toResponseDto(Category category) {

        CategoryResponseDto responseDto = mapper.map(category, CategoryResponseDto.class);


        return responseDto;
    }

    @Override
    public void toEntity(CategoryUpdateDto categoryUpdateDto, Category category) {
             mapper.map(categoryUpdateDto ,  category);
    }
}
