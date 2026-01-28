package com.vishalspring.product.controller;

import com.vishalspring.product.dto.CategoryDTO;
import com.vishalspring.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;
    // get all categories
    // create Categories
    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.createCategory(categoryDTO);
    }
    // get category by id
    // delete category
}
