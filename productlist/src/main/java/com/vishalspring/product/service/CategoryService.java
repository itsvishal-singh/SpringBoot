package com.vishalspring.product.service;

import com.vishalspring.product.dto.CategoryDTO;
import com.vishalspring.product.entity.Category;
import com.vishalspring.product.mapper.CategoryMapper;
import com.vishalspring.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    // create Category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }
    // get all categories
    // get category bt id
    // delete category

}
