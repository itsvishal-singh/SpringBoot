package com.vishalspring.product.service;

import com.vishalspring.product.dto.ProductDTO;
import com.vishalspring.product.entity.Category;
import com.vishalspring.product.entity.Product;
import com.vishalspring.product.mapper.ProductMapper;
import com.vishalspring.product.repository.CategoryRepository;
import com.vishalspring.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    // Create Products
    public ProductDTO createProduct(ProductDTO productDTO){
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not found!"));
         // DTO -> entity
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        // entity to DTO
        return ProductMapper.toProductDTO(product);
    }
    // Get All Products
    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }
    // Get Product By id
    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not Found"));
        return ProductMapper.toProductDTO(product);
    }
    // product update
    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not Found"));
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not Found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice((productDTO.getPrice()));
        product.setCategory(category);
        productRepository.save(product);
        return  ProductMapper.toProductDTO(product);

    }
    // product delete
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product " + id + " has been deleted";
    }


}
