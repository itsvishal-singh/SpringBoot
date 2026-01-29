package com.vishalspring.product.service;

import com.vishalspring.product.dto.ProductDTO;
import com.vishalspring.product.entity.Category;
import com.vishalspring.product.entity.Product;
import com.vishalspring.product.mapper.ProductMapper;
import com.vishalspring.product.repository.CategoryRepository;
import com.vishalspring.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){

        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not found!"));
         // DTO -> entity
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);

        // entity to DTO
        return ProductMapper.toProductDTO(product);
    }

}
