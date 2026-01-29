package com.vishalspring.product.controller;

import com.vishalspring.product.dto.ProductDTO;
import com.vishalspring.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    // getProduct
    // createProduct
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
       return productService.createProduct(productDTO);

    }
    // update product
    // get product by id
    // delete product
}
