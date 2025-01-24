package com.e_commerce.e_commerce.products;

import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<ProductsEntity, Long> {
    boolean existsByProductName(String productName);
}
