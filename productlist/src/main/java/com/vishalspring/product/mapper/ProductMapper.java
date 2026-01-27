package com.vishalspring.product.mapper;

import com.vishalspring.product.dto.ProductDTO;
import com.vishalspring.product.entity.Category;
import com.vishalspring.product.entity.Product;

public class ProductMapper {
    // entity to DTO
    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }
    // DTO to Entity
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return product;

    }
}
