package com.vishalspring.product.dto;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter @Setter
public class CategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
