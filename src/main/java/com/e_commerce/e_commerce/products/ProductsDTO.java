package com.e_commerce.e_commerce.products;

import lombok.*;


@Getter
@Setter
@Builder
public class ProductsDTO {
    private Long id;
    private String productName;
    private Double price;
    private Long quantity;
    private String categoryName;
}
