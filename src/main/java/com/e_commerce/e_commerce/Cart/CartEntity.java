package com.e_commerce.e_commerce.Cart;

import com.e_commerce.e_commerce.Login.AuthEntity;
import com.e_commerce.e_commerce.common.BaseEntity;
import com.e_commerce.e_commerce.products.ProductsEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "buy_operations")
public class CartEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private ProductsEntity products;

    @OneToOne
    private AuthEntity user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductsEntity getProducts() {
        return products;
    }

    public void setProducts(ProductsEntity products) {
        this.products = products;
    }

    public AuthEntity getUser() {
        return user;
    }

    public void setUser(AuthEntity user) {
        this.user = user;
    }
}
