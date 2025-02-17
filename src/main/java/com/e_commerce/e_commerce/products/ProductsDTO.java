package com.e_commerce.e_commerce.products;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductsDTO {
    private Long id;
    private String productName;
    private Double price;
    private Long quantity;
    private Long categoryId;
    private String categoryName;

}
