package com.e_commerce.e_commerce.Cart;

import com.e_commerce.e_commerce.Login.AuthEntity;
import com.e_commerce.e_commerce.common.BaseEntity;
import com.e_commerce.e_commerce.products.ProductsEntity;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "buy_operations")
@EntityListeners(AuditingEntityListener.class)
public class CartEntity extends BaseEntity {

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", productId=" + productId +
                ", products=" + products +
                ", userId=" + userId +
                ", authEntity=" + authEntity +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductsEntity products;

    @Column(name = "user_id")
    private Long userId;  // Здесь мы убираем дублирование логического имени

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private AuthEntity authEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductsEntity getProducts() {
        return products;
    }

    public void setProducts(ProductsEntity products) {
        this.products = products;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AuthEntity getAuthEntity() {
        return authEntity;
    }

    public void setAuthEntity(AuthEntity authEntity) {
        this.authEntity = authEntity;
    }

    public CartEntity(long id, Long productId, ProductsEntity products, Long userId, AuthEntity authEntity) {
        this.id = id;
        this.productId = productId;
        this.products = products;
        this.userId = userId;
        this.authEntity = authEntity;
    }

    public CartEntity() {
    }
}