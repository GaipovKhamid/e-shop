package com.e_commerce.e_commerce.products;

import com.e_commerce.e_commerce.category.CategoryEnums;

public class ProductsDTO {
    private Long id;
    private String productName;
    private Double price;
    private Long quantity;
    private CategoryEnums category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public CategoryEnums getCategory() {
        return category;
    }

    public void setCategory(CategoryEnums category) {
        this.category = category;
    }
}
