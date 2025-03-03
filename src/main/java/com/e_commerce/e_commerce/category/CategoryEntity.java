package com.e_commerce.e_commerce.category;

import com.e_commerce.e_commerce.common.BaseEntity;
import com.e_commerce.e_commerce.products.ProductsEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "products_name")
    private String productsName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_name", insertable = false, updatable = false)
    private ProductsEntity productsEntity;


}
