package com.e_commerce.e_commerce.products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
    boolean existsByProductName(String productId);

    Optional<ProductsEntity> findByIdAndDeletedAtIsNull(Long id);

    Page<ProductsEntity> findByProductName(String productName, Pageable pageable);

    Page<ProductsEntity> findByPriceBetween(Double lower, Double higher, Pageable pageable);

}
