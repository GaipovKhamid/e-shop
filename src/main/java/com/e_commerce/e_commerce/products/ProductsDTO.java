package com.e_commerce.e_commerce.products;

public class ProductsDTO {
    private Long id;
    private String productName;
    private Double price;
    private Long quantity;
    private Long categoryId;
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

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

    public ProductsDTO(){

    }

    public ProductsDTO(Long id, String productName, Long categoryId, String categoryName){
        this.id = id;
        this.productName = productName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public ProductsDTO(Long id, String productName, Double price, Long quantity,  String categoryName){
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.categoryName = categoryName;
    }

}
