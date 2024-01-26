package com.example.onefit.category;

import com.example.onefit.category.entity.Category;
import com.example.onefit.common.repository.GenericRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends GenericRepository<Category , String> {
}
