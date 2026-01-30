package com.vishalspring.product.controller;

import com.vishalspring.product.dto.ProductDTO;
import com.vishalspring.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    // getAllProduct
    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProducts();
    }
    // get product by id /product ? id ="", name=""
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
           return productService.getProductById(id);
}
    // createProduct
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO createdProduct = productService.createProduct(productDTO);
          return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    // delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
