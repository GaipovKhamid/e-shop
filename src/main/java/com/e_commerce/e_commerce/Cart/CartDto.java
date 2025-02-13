package com.e_commerce.e_commerce.Cart;

public class CartDto {
    private Long id;
    private Long userId;
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long  productId) {
        this.productId = productId;
    }

    public CartDto() {
    }

    public CartDto(Long id, Long userId, Long productId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}
