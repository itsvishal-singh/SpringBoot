package com.vishalspring.product.service;

import com.vishalspring.product.dto.CategoryDTO;
import com.vishalspring.product.entity.Category;
import com.vishalspring.product.mapper.CategoryMapper;
import com.vishalspring.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {


    private CategoryRepository categoryRepository;
    // create Category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }
    // get all categories
    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }
    // get category bt id
    public  CategoryDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }
    // delete category
    public String  deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category " + id + " has been Deleted";
    }

}
