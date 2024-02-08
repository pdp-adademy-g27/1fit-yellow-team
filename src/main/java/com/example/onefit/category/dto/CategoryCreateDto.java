package com.example.onefit.category.dto;


import lombok.*;


@NoArgsConstructor
public class CategoryCreateDto extends CategoryBaseDto{

    public CategoryCreateDto(String name , String smallImage , String bigImage){
        super(name , smallImage , bigImage);
    }

}
